package com.augmentum.oes.dao.impl;

import java.util.List;

import com.augmentum.oes.common.Constants;
import com.augmentum.oes.dao.QuestionDao;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.model.Question;

public class QuestionDaoImpl extends BaseDaoImpl<Question, Integer> implements QuestionDao {

    public QuestionDaoImpl() {
    }

    @Override
    public List<Question> query(Pagination<Question> page) {

        int count = super.getCount(page);
        page.setCount(count);
        return super.query(page.getParams());
    }

    @Override
    public List<Question> getQuestionsByRandom(int number) {
        return super.getSqlSession().selectList(super.getActuallModleClassType().getName() + Constants.SQL_ID_QUEYRRANDOM, number);
    }

}
