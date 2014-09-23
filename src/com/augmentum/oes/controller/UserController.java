package com.augmentum.oes.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.common.Constants;
import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.User;
import com.augmentum.oes.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource(name = "userService")
    private UserService userService = null;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/loginCheck"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(Constants.MAIN);
        HttpSession session = request.getSession();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = userService.login(userName, password);

        if (user != null) {
            session.setAttribute("user", user);
        } else {
            mav = new ModelAndView(Constants.LOGIN);
            mav.addObject("error", "user name or password error!");
            mav.addObject(userName);
        }
        return mav;
    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView toLoginJsp() {
        ModelAndView mav = new ModelAndView(Constants.LOGIN);
        return mav;
    }

    @RequestMapping(value = ("/logout"), method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(Constants.LOGIN);

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return mav;
    }

    @RequestMapping(value = {"/edit"})
    public ModelAndView toEditMyProfile() {
        ModelAndView mav = new ModelAndView(Constants.PROFILE);
        return mav;
    }

    @RequestMapping(value = {"/update"})
    @ResponseBody
    public ModelAndView updateMyProfile(HttpServletRequest request, User user) {
        ModelAndView mav;
        HttpSession session = request.getSession();
        User oldUser = (User) session.getAttribute("user");
        try {
            userService.update(user);
            user.setUserName(oldUser.getUserName());
            session.setAttribute("user", user);
            mav = new ModelAndView(Constants.MAIN);
        } catch (VerificationException e) {
            Map<String, String> exceptionMessageMap = e.getExceptionMap();
            session.setAttribute("exceptionMessage", exceptionMessageMap);

            mav = new ModelAndView(Constants.PROFILE);
        }
        return mav;
    }

}
