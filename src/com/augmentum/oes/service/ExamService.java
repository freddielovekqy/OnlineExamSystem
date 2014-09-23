package com.augmentum.oes.service;

import java.util.List;

import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.Exam;
import com.augmentum.oes.model.Pagination;

public interface ExamService {

    public List<Exam> queryExamByPage(Pagination<Exam> page);
    public int createNewExam(Exam exam) throws VerificationException;
    public int getQuestionCount();
}
