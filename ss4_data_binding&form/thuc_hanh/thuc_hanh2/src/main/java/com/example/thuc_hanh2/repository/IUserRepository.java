package com.example.thuc_hanh2.repository;

import com.example.thuc_hanh2.model.Login;
import com.example.thuc_hanh2.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
