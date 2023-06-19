package com.example.bai_tap1.service;

import com.example.bai_tap1.model.Mail;

import java.util.List;

public interface IMailService {
    List<String> getLanguages();

    List<Integer> getPageSizes();

    Mail getMail();

    void update(Mail mail);
}
