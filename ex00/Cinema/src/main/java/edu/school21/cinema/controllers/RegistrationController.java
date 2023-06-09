package edu.school21.cinema.controllers;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String signUpSave(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "signUp";
        }
        if (!userService.saveUser(user)){
            model.addAttribute("usernameError", "Пользователь с таким email уже существует");
            return "signUp";
        }

        return "redirect:/signIn";
    }
}
