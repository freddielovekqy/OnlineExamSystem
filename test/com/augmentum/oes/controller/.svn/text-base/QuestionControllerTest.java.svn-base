package com.augmentum.oes.controller;

import javax.annotation.Resource;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.oes.model.Question;
import com.augmentum.oes.service.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitApplicationContext.xml", "classpath:springMVC.xml"})
public class QuestionControllerTest {

    @Resource
    private QuestionController questionController;

    @Test
    public void testDelete() {

        int id = 1;

        QuestionService questionService = EasyMock.createMock(QuestionService.class);

        questionService.deleteQuestionById(id);
        EasyMock.expectLastCall();
        EasyMock.replay(questionService);


        (questionController).setQuestionService(questionService);

        String result = questionController.delete(String.valueOf(id));

        Assert.assertEquals(result, "true");

        EasyMock.verify(questionService);
    }

    @Test
    public void testEdit() {

        Question question = new Question();
        question.setQuestionTitle("123");
        question.setOptionA("1");
        question.setOptionB("2");
        question.setOptionC("3");
        question.setOptionD("4");
        question.setAnswer("A");
        int id = 1;

        QuestionService questionService = EasyMock.createMock(QuestionService.class);
        EasyMock.expect(questionService.getQuestionById(id)).andReturn(question);
        EasyMock.replay(questionService);


        (questionController).setQuestionService(questionService);

        ModelAndView mav = questionController.edit(String.valueOf(id));

        Assert.assertEquals(mav.getModel().get("question"), question);

        EasyMock.verify(questionService);
    }

    /*@Test
    public void testView() {

        Pagination page = new Pagination();
        page.setPageSize(10);
        page.setCurrentPage(1);
        page.addParam("queryCondition", "%a%");

        List<Question> list = new ArrayList<Question>();

        QuestionService questionService = EasyMock.createMock(QuestionService.class);
        EasyMock.expect(questionService.queryQuestionByPage(page)).andReturn(list);
        EasyMock.replay(questionService);


        questionController.setQuestionService(questionService);

        ModelAndView mav =  questionController.view("1", "%a%");


        Assert.assertEquals(page, mav.getModel().get("page"));
        Assert.assertEquals(list, mav.getModel().get("questionList"));
        Assert.assertEquals(Constants.QUERY_QUESTION, mav.getViewName());

        EasyMock.verify(questionService);
    }*/


}
