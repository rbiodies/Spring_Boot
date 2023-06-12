package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Data;
import edu.school21.cinema.models.ERole;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class MainController {
    private static final String LOCALHOST_v6 = "0:0:0:0:0:0:0:1";
    private static final String LOCALHOST_v4 = "127.0.0.1";

    @Autowired
    private DataService dataService;

    @GetMapping("/signIn")
    public String signInForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signIn";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(@Valid User user, HttpServletRequest request) {
        dataService.save(new Data(user, getClientDate(), getClientTime(), getClientIP(request)));
        if (request.isUserInRole(ERole.ROLE_ADMIN.name())) {
            return "redirect:/admin/panel/halls/";
        }
        return "redirect:/profile/";
    }

    private String getClientDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy").withLocale(Locale.ENGLISH);
        return now.format(formatter);
    }

    private String getClientTime() {
        LocalTime now = LocalTime.now();
        return now.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals(LOCALHOST_v6)) {
            ip = LOCALHOST_v4;
        }
        return ip;
    }

    @RequestMapping("/chat/{film-id}")
    public String showMovie(@PathVariable("film-id") String parameter) {
        return "chat";
    }
}
