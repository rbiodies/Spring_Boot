package edu.school21.cinema.controllers;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

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
//            model.addAttribute("passwordError", "Пароли не совпадают");
            return "signUp";
        }
        if (!userService.saveUser(user)){
            bindingResult.rejectValue("email", "user.email.exists");
//            model.addAttribute("usernameError", "Пользователь с таким email уже существует");
            return "signUp";
        }

        return "redirect:/signIn";
    }
}
