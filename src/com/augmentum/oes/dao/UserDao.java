package com.augmentum.oes.dao;

import com.augmentum.oes.model.User;

public interface UserDao {

    public User login(String userName, String password);
    public void update(User user);
}
