package edu.school21.cinema.controllers;

import edu.school21.cinema.models.ERole;
import edu.school21.cinema.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/signIn")
    public String signInForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signIn";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole(ERole.ROLE_ADMIN.name())) {
            return "redirect:/admin/panel/halls/";
        }
        return "redirect:/profile/";
    }

    @RequestMapping("/chat/{film-id}")
    public String showMovie(@PathVariable("film-id") String parameter) {
        return "chat";
    }
}
