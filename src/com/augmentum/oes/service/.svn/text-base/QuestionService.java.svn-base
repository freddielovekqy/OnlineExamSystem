package com.augmentum.oes.service;

import java.util.List;

import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.Question;

public interface QuestionService {

    public void deleteQuestionById(int id);
    public Question getQuestionById(int id);
    public int saveQuestion(Question question) throws VerificationException;
    public List<Question> queryQuestionByPage(Pagination<Question> page);
}
