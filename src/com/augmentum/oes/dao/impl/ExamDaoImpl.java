package com.augmentum.oes.dao.impl;

import java.util.List;

import com.augmentum.oes.dao.ExamDao;
import com.augmentum.oes.model.Exam;
import com.augmentum.oes.model.Pagination;

public class ExamDaoImpl extends BaseDaoImpl<Exam, Integer> implements ExamDao {

    @Override
    public int create(Exam exam) {
        return super.create(exam);
    }

    @Override
    public List<Exam> query(Pagination<Exam> page) {
        int count = super.getCount(page);
        page.setCount(count);
        return super.query(page.getParams());
    }
}
