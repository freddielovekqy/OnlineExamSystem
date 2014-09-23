package com.augmentum.oes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.augmentum.oes.dao.ExamDao;
import com.augmentum.oes.dao.ExamPaperDao;
import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.Exam;
import com.augmentum.oes.model.ExamPaper;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.Question;
import com.augmentum.oes.service.BaseService;
import com.augmentum.oes.service.ExamService;

public class ExamServiceImpl extends BaseService implements ExamService {

    private ExamDao examDao = null;
    private QuestionDao questionDao = null;
    private ExamPaperDao examPaperDao = null;

    public ExamServiceImpl() {

    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public ExamDao getExamDao() {
        return examDao;
    }

    public void setExamDao(ExamDao examDao) {
        this.examDao = examDao;
    }

    public ExamPaperDao getExamPaperDao() {
        return examPaperDao;
    }

    public void setExamPaperDao(ExamPaperDao examPaperDao) {
        this.examPaperDao = examPaperDao;
    }

    public List<Exam> queryExamByPage(Pagination<Exam> page) {
        page.addParam("begin", String.valueOf(page.getBegin()));
        page.addParam("pageSize", String.valueOf(page.getPageSize()));
        return examDao.query(page);
    }

    public int createNewExam(Exam exam) throws VerificationException {

        this.validateObject(exam);

        examDao.create(exam);
        List<Question> questionList = questionDao.getQuestionsByRandom(exam.getQuestionQuantity());

        ExamPaper examPaper = null;
        List<ExamPaper> examPaperList = new ArrayList<ExamPaper>();

        for (int i = 0;i< questionList.size(); i++) {
            examPaper = new ExamPaper();
            examPaper.setExamId(exam.getId());
            examPaper.setQuestionId(questionList.get(i).getId());
            examPaper.setQuestionOrder(i + 1);
            examPaper.setQuestionTitle(questionList.get(i).getQuestionTitle());
            examPaper.setOptionA(questionList.get(i).getOptionA());
            examPaper.setOptionB(questionList.get(i).getOptionB());
            examPaper.setOptionC(questionList.get(i).getOptionC());
            examPaper.setOptionD(questionList.get(i).getOptionD());
            examPaper.setAnswer(questionList.get(i).getAnswer());

            examPaperList.add(examPaper);
        }

        examPaperDao.create(examPaperList);

        return exam.getId();
    }

    public int getQuestionCount() {
        Pagination<Question> page = new Pagination<Question>();
        page.addParam("queryCondition", "%%");

        return questionDao.getCount(page);
    }
}
