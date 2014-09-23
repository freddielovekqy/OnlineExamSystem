package com.augmentum.oes.dao;

import java.util.List;

import com.augmentum.oes.model.Exam;
import com.augmentum.oes.model.Pagination;

public interface ExamDao {

    public List<Exam> query(Pagination<Exam> page);
    public int create(Exam exam);
}
