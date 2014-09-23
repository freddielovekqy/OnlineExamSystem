package com.augmentum.oes.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.common.Constants;
import com.augmentum.oes.model.Exam;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.User;
import com.augmentum.oes.service.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController extends BaseController {

    @Resource(name = "examService")
    private ExamService examService;

    @RequestMapping(value = {"/view"})
    public ModelAndView view(@RequestParam(value = ("currentPage")) String currentPage, @RequestParam(value = ("examName")) String examName) {
        ModelAndView mav = new ModelAndView(Constants.EXAM_LIST);

        Pagination<Exam> page = new Pagination<Exam>();
        page.setCurrentPage(currentPage);
        page.setUrl("view?examName=" + examName);
        page.addParam("queryCondition", "%" + examName + "%");

        List<Exam> examList = examService.queryExamByPage(page);

        mav.addObject("examList", examList);
        mav.addObject("page", page);
        mav.addObject("examName", examName);

        return mav;
    }

    @RequestMapping(value = {"/create"})
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView(Constants.CREATE_EXAM);
        return mav;
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ModelAndView save(HttpSession session, Exam exam) {
        User user = (User) session.getAttribute("user");

        try {
            exam.setUserId(user.getId());
            examService.createNewExam(exam);

            return new ModelAndView("redirect:/exam/view?examName=&currentPage=");
        } catch (Exception e) {
            return new ModelAndView("redirect:/exam/error");
        }
    }

    @RequestMapping(value = {"/isHasEnoughQuestion"}, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String isHasEnoughQuestion(@RequestParam(value = ("questionQuantity")) String questionQuantity) {
        int questionCount = examService.getQuestionCount();

        if (questionCount < Integer.parseInt(questionQuantity)) {
            return "false";
        } else {
            return "true";
        }
    }

    @RequestMapping(value = {"/error"})
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView(Constants.ERROR);
        return mav;
    }
}
