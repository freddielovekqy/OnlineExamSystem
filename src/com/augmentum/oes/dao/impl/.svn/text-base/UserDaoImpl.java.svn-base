package com.augmentum.oes.dao.impl;

import com.augmentum.oes.common.Constants;
import com.augmentum.oes.dao.UserDao;
import com.augmentum.oes.model.User;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

    public User login(String userName, String password) {

        User user =  super.getSqlSession().selectOne(super.getActuallModleClassType().getName() + Constants.SQL_ID_LOGIN , userName);

        if (user.getPassword().equals(password)) {
            user.setPassword("");
        } else {
            user = null;
        }
        return user;
    }
}
