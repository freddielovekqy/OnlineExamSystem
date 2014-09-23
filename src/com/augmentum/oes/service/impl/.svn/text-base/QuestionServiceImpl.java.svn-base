package com.augmentum.oes.service.impl;

import java.util.List;

import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.Question;
import com.augmentum.oes.service.BaseService;
import com.augmentum.oes.service.QuestionService;

public class QuestionServiceImpl extends BaseService implements QuestionService {

    private QuestionDao questionDao = null;

    public QuestionServiceImpl() {
    }

    public int saveQuestion(Question question) throws VerificationException {

        this.validateObject(question);

        if (question.getId() == 0) {
            questionDao.create(question);
            return question.getId();
        } else {
            questionDao.update(question);
            return 1;
        }
    }

    public void deleteQuestionById(int id) {
        questionDao.delete(id);
    }

    public Question getQuestionById(int id) {

        return questionDao.getById(id);
    }

    public List<Question> queryQuestionByPage(Pagination<Question> page) {

        page.addParam("pageSize", String.valueOf(page.getPageSize()));
        page.addParam("begin", String.valueOf(page.getBegin()));

        return questionDao.query(page);
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

}
