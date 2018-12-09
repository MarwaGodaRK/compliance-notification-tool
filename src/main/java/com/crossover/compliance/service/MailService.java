package com.crossover.compliance.service;

import com.crossover.compliance.config.ApplicationProperties;
import com.crossover.compliance.config.MailMessageConfig;
import com.crossover.compliance.domain.User;
import com.crossover.compliance.model.Candidate;
import com.crossover.compliance.model.CandidateNonCompliance;
import com.crossover.compliance.model.IcCompliance;
import com.crossover.compliance.model.Manager;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Service for sending emails.
 * <p>
 * We use the @Async annotation to send emails asynchronously.
 */
@Service
public class MailService {

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    private static final String DATA = "data";

    private static final String BASE_URL = "baseUrl";

    private final MailMessageConfig mailMessageConfig;

    private final JavaMailSender javaMailSender;

    private final MessageSource messageSource;

    private final TemplateEngine templateEngine;

    public MailService(MailMessageConfig mailMessageConfig, JavaMailSender javaMailSender,
            MessageSource messageSource, SpringTemplateEngine templateEngine) {

        this.mailMessageConfig = mailMessageConfig;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
            isMultipart, isHtml, to, subject, content);

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom(mailMessageConfig.getFrom());
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", to);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.warn("Email could not be sent to user '{}'", to, e);
            } else {
                log.warn("Email could not be sent to user '{}': {}", to, e.getMessage());
            }
        }
    }

    @Async
    public void sendEmailFromTemplate(Map<Manager, List<CandidateNonCompliance>> dataMap) {
        Context context = new Context();
        dataMap.entrySet().forEach( managerMapEntry -> {
            if(managerMapEntry.getValue().size() > 0) {
                context.setVariable("Manager", managerMapEntry.getKey());
                context.setVariable(DATA, managerMapEntry.getValue());
                String content = templateEngine.process(mailMessageConfig.getTemplate(), context);
                sendEmail(managerMapEntry.getKey().getEmail(), mailMessageConfig.getSubject(), content, false, true);
            }
        });
    }

}
