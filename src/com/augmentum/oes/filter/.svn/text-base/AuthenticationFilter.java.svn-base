package com.augmentum.oes.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.augmentum.oes.model.User;

public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/login");
            return;
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
