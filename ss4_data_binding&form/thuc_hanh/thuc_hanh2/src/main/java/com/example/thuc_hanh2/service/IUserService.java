package com.example.thuc_hanh2.service;

import com.example.thuc_hanh2.model.Login;
import com.example.thuc_hanh2.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
