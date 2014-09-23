package com.augmentum.oes.service.impl;

import com.augmentum.oes.dao.UserDao;
import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.User;
import com.augmentum.oes.service.BaseService;
import com.augmentum.oes.service.UserService;

public class UserServiceImpl extends BaseService implements UserService {

    private UserDao userDao = null;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String userName, String password) {
        return userDao.login(userName, password);
    }

    public void update(User user) throws VerificationException {
        this.validateObject(user);
        userDao.update(user);
    }
}
