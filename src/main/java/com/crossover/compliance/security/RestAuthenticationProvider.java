package com.crossover.compliance.security;

import com.crossover.compliance.config.ApplicationProperties;
import com.crossover.compliance.model.Dashboard;
import com.crossover.compliance.model.UserDetail;
import com.crossover.compliance.repository.UserRepository;
import com.crossover.compliance.service.rest.RestClient;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.expression.Lists;

@Component
public class RestAuthenticationProvider  extends AbstractUserDetailsAuthenticationProvider {

    private final ApplicationProperties applicationProperties;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestClient restClient;

    public RestAuthenticationProvider(ApplicationProperties applicationProperties){
        this.applicationProperties = applicationProperties;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
        UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken auth)
        throws AuthenticationException {
        String password = auth.getCredentials().toString();
        UserDetails loadedUser=null;

        try {

            ResponseEntity<AuthenticationToken> authenticationResponse = restClient.authenticate(username, password);
            if (authenticationResponse.getStatusCode().value() == 401) {
                List<GrantedAuthority> newArrayList = new ArrayList<>();
                return new User("wrongUsername", "wrongPass", newArrayList);
            }
            AuthenticationToken principalFromRest = authenticationResponse.getBody();

            ResponseEntity<UserDetail> userDetailResponseEntity  = restClient.retrieveUserDetails(username, password);
            if (userDetailResponseEntity.getStatusCode().value() == 401) {
                List<GrantedAuthority> newArrayList = new ArrayList<>();
                return new User("wrongUsername", "wrongPass", newArrayList);
            }
            UserDetail userDetail = userDetailResponseEntity.getBody();

            List<GrantedAuthority> authorities =
                    AuthorityUtils
                            .createAuthorityList(userDetail.getAvatarTypes()
                                    .toArray(new String[userDetail.getAvatarTypes().size()]));
            com.crossover.compliance.domain.User domainUser = null;
            if(userDetail.getAvatarTypes().stream().filter(t->t.equalsIgnoreCase("MANAGER")).findFirst().isPresent()){
                ResponseEntity<Dashboard> dashboardResponseEntity = restClient.getTeamDetails(username, password, userDetail.getManagerAvatar().getId());

                domainUser =
                        fillUser(userDetail, dashboardResponseEntity.getBody(), principalFromRest);
                userRepository.delete(domainUser);
                userRepository.insert(domainUser);
            }
            loadedUser = new SecurityUserDetails(username, password, authorities, domainUser.getUserId(), domainUser.getTeamIds());

        } catch (Exception ex) {
            throw new AuthenticationServiceException(ex.getMessage());
        }
        return loadedUser;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");
        this.passwordEncoder = passwordEncoder;
    }

    protected PasswordEncoder getPasswordEncoder() {
        return this.passwordEncoder;
    }

    private com.crossover.compliance.domain.User fillUser(UserDetail userDetail, Dashboard body,
            AuthenticationToken principalFromRest) {
        com.crossover.compliance.domain.User user = new com.crossover.compliance.domain.User();
        user.setUserId(userDetail.getManagerAvatar().getId());
        user.setFullName(userDetail.getFullName());
        user.setTeamIds(body.getTeams().stream().map(t->t.getId()).collect(Collectors.toList()));
        user.setRoles(userDetail.getAvatarTypes());
        user.setToken(principalFromRest.getToken());
        return user;
    }
}
