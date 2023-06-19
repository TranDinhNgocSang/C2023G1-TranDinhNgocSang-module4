package com.example.thuc_hanh2.service.impl;

import com.example.thuc_hanh2.model.Login;
import com.example.thuc_hanh2.model.User;
import com.example.thuc_hanh2.repository.impl.UserRepository;
import com.example.thuc_hanh2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
