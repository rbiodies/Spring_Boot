package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CinemaController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping("/session/search")
    public String sessions(Model model) {
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions", sessions);
        return "cinema";
    }

    @RequestMapping("/sessions/search")
    @ResponseBody
    public List<Session> searchSessionForm(@RequestParam String filmName) {
        return sessionService.findByFilmName(filmName);
    }

    @RequestMapping("/sessions/{sessionId}")
    public ModelAndView showMovie(@PathVariable("sessionId") Long sessionId) {
        ModelAndView mav = new ModelAndView("movie");
        Session session = sessionService.findById(sessionId);
        mav.addObject("session", session);

        return mav;
    }
}
