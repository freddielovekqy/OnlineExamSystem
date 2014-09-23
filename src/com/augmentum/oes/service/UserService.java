package com.augmentum.oes.service;

import com.augmentum.oes.exception.VerificationException;
import com.augmentum.oes.model.User;

public interface UserService {

    public User login(String userName, String password);
    public void update(User user) throws VerificationException;
}
