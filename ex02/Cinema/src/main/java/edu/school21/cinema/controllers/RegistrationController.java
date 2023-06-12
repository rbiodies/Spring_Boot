package edu.school21.cinema.controllers;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messages;

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());

        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUpSave(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            bindingResult.rejectValue("password", "user.password.mismatch");
            return "signUp";
        }
        if (!userService.saveUser(user)){
            bindingResult.rejectValue("email", "user.email.exists");
            return "signUp";
        }

        return "verification";
    }

    @RequestMapping("/confirm/{token}")
    public String verifyCustomer(@PathVariable("token") String token, Model model) {

        Locale locale = LocaleContextHolder.getLocale();
        String message;

        model.addAttribute("user", new User());
        if(StringUtils.isEmpty(token)){
            message = messages.getMessage("user.registration.verification.missing.token", null, locale);
            model.addAttribute("tokenError", message);
            return "signIn";
        }
        try {
            userService.verifyUser(token);
        } catch (Exception e) {
            message = messages.getMessage("user.registration.verification.invalid.token", null, locale);
            model.addAttribute("tokenError", message);
            return "signIn";
        }
        message = messages.getMessage("user.registration.verification.success", null, locale);
        model.addAttribute("verifiedAccountMsg", message);
        return "signIn";
    }
}
