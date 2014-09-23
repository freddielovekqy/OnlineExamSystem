package com.augmentum.oes.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.augmentum.oes.common.Constants;
import com.augmentum.oes.exception.DBException;
import com.augmentum.oes.model.Pagination;
import com.augmentum.oes.util.LogUtil;

public abstract class BaseDaoImpl<T, K> extends SqlSessionDaoSupport {

    @SuppressWarnings("unchecked")
    protected Class<T> getActuallModleClassType() {
        Class<T> classType = null;
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        classType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return classType;
    }

    public int create(T object) {
        int id = 0;
        id = this.getSqlSession().insert(this.getActuallModleClassType().getName() + Constants.SQL_ID_ADD , object);

        return id;
    }

    public void delete(K id) {
        this.getSqlSession().delete(this.getActuallModleClassType().getName() + Constants.SQL_ID_DELETE , id);
    }

    public void update(T object) throws DBException {
        try{
            this.getSqlSession().update(this.getActuallModleClassType().getName() + Constants.SQL_ID_UPDATE, object);
        }catch (DBException e) {
            e.printStackTrace();
            LogUtil.log(e);
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public T getById(K id) {
        T result = null;
        result = (T)this.getSqlSession().selectOne(this.getActuallModleClassType().getName() + Constants.SQL_ID_BY_ID , id);
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<T> query(Map<String, String> map) {
        List<T> list = null;
        list = (List<T>) this.getSqlSession().selectList(this.getActuallModleClassType().getName() + Constants.SQL_ID_QUERY, map);
        return list;
    }

    public int getCount(Pagination<T> page) {
        int count = Integer.parseInt(this.getSqlSession().selectOne(this.getActuallModleClassType().getName() + Constants.SQL_ID_COUNT , page.getParams().get("queryCondition")).toString());
        return count;
    }

}
