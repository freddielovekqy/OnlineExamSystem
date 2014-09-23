package com.augmentum.oes.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.common.Constants;
import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.Question;
import com.augmentum.oes.model.User;
import com.augmentum.oes.service.QuestionService;
import com.augmentum.oes.util.StringUtil;

@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {

    @Resource(name = "questionService")
    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view() {
        ModelAndView mav = new ModelAndView(Constants.QUERY_QUESTION);

        Pagination<Question> page = new Pagination<Question>();
        page.setCurrentPage(1);
        page.addParam("queryCondition", "%%");
        page.addParam("sort", "lastUpdateTime_desc");

        List<Question> questionList = questionService.queryQuestionByPage(page);

        mav.addObject("questionList", questionList);
        mav.addObject("page", page);

        return mav;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public @ResponseBody Pagination<Question> query(@RequestParam(value = ("currentPage")) String currentPage,
            @RequestParam(value = "questionTitle") String questionTitle,
            @RequestParam(value = "pageSize") String pageSize,
            @RequestParam(value = "sort") String sort) {

        Pagination<Question> page = new Pagination<Question>();
        page.setCurrentPage(currentPage);
        page.addParam("queryCondition", "%" + questionTitle + "%");

        page.addParam("sort", sort);

        if (!StringUtil.isEmpty(pageSize)) {
            page.setPageSize(Integer.parseInt(pageSize));
        }

        List<Question> questionList = questionService.queryQuestionByPage(page);

        page.setList(questionList);

        return page;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView(Constants.CREATE_QUESTION);
        mav.addObject("question", new Question());
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request, Question question) {
        HttpSession session = request.getSession();

        try {
            if (question.getId() == 0) {
                User user = (User) session.getAttribute("user");
                question.setUserId(user.getId());
            }
            questionService.saveQuestion(question);

            return new ModelAndView("redirect:/question/view?currentPage=&questionTitle=");
        } catch (VerificationException e) {
            Map<String, String> exceptionMessageMap = e.getExceptionMap();
            session.setAttribute("exceptionMessage", exceptionMessageMap);

            return new ModelAndView("redirect:/question/error");
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = ("id")) String id) {
        ModelAndView mav = new ModelAndView(Constants.CREATE_QUESTION);
        int questionId = Integer.parseInt(id);

        Question question = questionService.getQuestionById(questionId);
        mav.addObject("question", question);

        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable(value = "id") String id) {
        int questionId = Integer.parseInt(id);

        questionService.deleteQuestionById(questionId);

        return "true";
    }

    @RequestMapping(value = "/error", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView toErrorPage() {
        ModelAndView mav = new ModelAndView(Constants.ERROR);
        return mav;
    }
}
