package com.augmentum.oes.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.exception.DBException;
import com.augmentum.oes.util.LogUtil;

public class BaseController {
    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handleException(DBException ex) {
        ModelAndView mav = new ModelAndView("error500Page");
        mav.addObject("Exception", ex.getMessage());

        LogUtil.log(ex);
        return mav;
    }

}
