package com.crossover.compliance;

import com.crossover.compliance.model.ComplianceRules;
import com.crossover.compliance.service.RulesServices;
import java.util.List;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    RulesServices rulesServices;
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("redirect:/configureRules");
    }
    @GetMapping("/configureRules")
    public String configureRules(Model model) {

        model.addAttribute("complianceRules", new ComplianceRules());
        model.addAttribute("stops", initializeStops());
        model.addAttribute("hours", initializeHours());
        model.addAttribute("percentages", initializePercentages());
        return "configureRules";

    }


    @PostMapping("/configureRules")
    public String configureRules(@Valid @ModelAttribute("complianceRules") ComplianceRules complianceRules,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "configureRules";
        }
        rulesServices.removeLoggedInUserComplianceRules();
        rulesServices.addComplianceRules(complianceRules);

        return "result";
    }

    private int[] initializeHours() {
        return IntStream.range(0, 25).toArray();

    }

    private int[] initializePercentages() {
        return IntStream.range(1, 101).toArray();

    }

    private int[] initializeStops() {
        return IntStream.range(1, 11).toArray();

    }


}
