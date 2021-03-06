package com.augmentum.oes.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.oval.Validator;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.Question;
import com.augmentum.oes.service.impl.QuestionServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitApplicationContext.xml", "classpath:springMVC.xml"})
public class QuestionServiceTest {

    @Resource
    private QuestionService questionService;

    @Test
    public void testVerificationException() throws VerificationException {
        Question question = new Question();
        try {
            ((QuestionServiceImpl.class.cast(questionService))).validateObject(question);
        } catch (VerificationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateQuestion() {
        QuestionDao questionDao = EasyMock.createMock(QuestionDao.class);
        Question question = new Question();

        question.setQuestionTitle("1+1=?");
        question.setOptionA("1");
        question.setOptionB("2");
        question.setOptionC("3");
        question.setOptionD("4");
        question.setAnswer("B");

        EasyMock.expect(questionDao.create(question)).andReturn(question.getId());

        EasyMock.replay(questionDao);

        Validator validator = new Validator();
        ((QuestionServiceImpl.class.cast(questionService))).setValidator(validator);
        ((QuestionServiceImpl.class.cast(questionService))).setQuestionDao(questionDao);
        int result = 0;
        try {
            result = questionService.saveQuestion(question);


        } catch (VerificationException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(question.getId());
        Assert.assertEquals(result, question.getId());

    }

    @Test
    public void testUpdateQuestion() {
        Question question = new Question();
        question.setId(1);
        question.setQuestionTitle("1+1=?");
        question.setOptionA("1");
        question.setOptionB("2");
        question.setOptionC("3");
        question.setOptionD("4");
        question.setAnswer("B");

        QuestionDao questionDao = EasyMock.createMock(QuestionDao.class);

        questionDao.update(question);
        EasyMock.expectLastCall();

        EasyMock.replay(questionDao);

        ((QuestionServiceImpl.class.cast(questionService))).setQuestionDao(questionDao);

        try {
            questionService.saveQuestion(question);
        } catch (VerificationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetQuestionById() {
        Question question = new Question();
        question.setQuestionTitle("1+1=?");
        question.setOptionA("1");
        question.setOptionB("2");
        question.setOptionC("3");
        question.setOptionD("4");
        question.setAnswer("B");

        int id = 1;

        QuestionDao questionDao = EasyMock.createMock(QuestionDao.class);
        EasyMock.expect(questionDao.getById(id)).andReturn(question);
        EasyMock.replay(questionDao);

        ((QuestionServiceImpl.class.cast(questionService))).setQuestionDao(questionDao);

        Question result = questionService.getQuestionById(id);
        Assert.assertEquals(result, question);

        EasyMock.verify(questionDao);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testQueryQuestionByPage() {

        Pagination page = new Pagination();
        List<Question> list = new ArrayList<Question>();

        QuestionDao questionDao = EasyMock.createMock(QuestionDao.class);
        EasyMock.expect(questionDao.query(page)).andReturn(list);
        EasyMock.replay(questionDao);

        ((QuestionServiceImpl.class.cast(questionService))).setQuestionDao(questionDao);

        List<Question> result = questionService.queryQuestionByPage(page);
        Assert.assertEquals(result, list);

        EasyMock.verify(questionDao);
    }

    @Test
    public void testDeleteQuestion() {

        int id = 1;

        QuestionDao questionDao = EasyMock.createMock(QuestionDao.class);
        questionDao.delete(id);
        EasyMock.expectLastCall();
        EasyMock.replay(questionDao);

        ((QuestionServiceImpl.class.cast(questionService))).setQuestionDao(questionDao);

        questionService.deleteQuestionById(id);

        EasyMock.verify(questionDao);
    }

}
