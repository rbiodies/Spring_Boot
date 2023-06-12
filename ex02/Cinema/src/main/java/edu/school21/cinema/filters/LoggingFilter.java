package edu.school21.cinema.filters;

import edu.school21.cinema.models.ERole;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Component
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();

        Principal principal = req.getUserPrincipal();

        if (principal != null && (uri.endsWith("/signUp") || uri.endsWith("/signIn"))) {
            if (req.isUserInRole(ERole.ROLE_ADMIN.name())) {
                res.sendRedirect("/admin/panel/halls");
            } else if (req.isUserInRole(ERole.ROLE_USER.name())) {
                res.sendRedirect("/profile");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
