package com.example.bai_tap1.repository;

import com.example.bai_tap1.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<String> getLanguages ();

    List<Integer> getPageSizes ();

    Mail getMail ();

    void update(Mail mail);
}
