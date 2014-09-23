package com.augmentum.oes.dao;

import java.util.List;

import com.augmentum.oes.model.Pagination;

public interface BaseDAO <T, K> {

    public int create(T object);
    public void delete(K id);
    public void update(T object);
    public T getById(K id);
    public List<T> query(Pagination<T> page);
}
