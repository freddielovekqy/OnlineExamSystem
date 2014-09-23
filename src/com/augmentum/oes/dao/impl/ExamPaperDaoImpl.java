package com.augmentum.oes.dao.impl;

import java.util.List;

import com.augmentum.oes.dao.ExamPaperDao;
import com.augmentum.oes.model.ExamPaper;

public class ExamPaperDaoImpl extends BaseDaoImpl<ExamPaper, Integer> implements ExamPaperDao {

    public void create(List<ExamPaper> list) {

        for (ExamPaper examPaper : list) {
            super.create(examPaper);
        }
    }

    public void add() {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setExamId(35);
        examPaper.setQuestionId(1);
        examPaper.setQuestionOrder(1);
        examPaper.setQuestionTitle("111");
        examPaper.setAnswer("a");
        examPaper.setOptionA("a");
        examPaper.setOptionB("a");
        examPaper.setOptionC("a");
        examPaper.setOptionD("a");
        super.create(examPaper);
    }
}
