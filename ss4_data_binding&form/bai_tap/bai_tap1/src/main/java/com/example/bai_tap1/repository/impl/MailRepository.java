package com.example.bai_tap1.repository.impl;

import com.example.bai_tap1.model.Mail;
import com.example.bai_tap1.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository {
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> pageSize = new ArrayList<>();
    private static Mail mail = new Mail("Vietnamese", 10, true, "Tran Dinh Ngoc Sang");

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getPageSizes() {
        return pageSize;
    }

    @Override
    public Mail getMail() {
        return mail;
    }

    @Override
    public void update(Mail mailUpdate) {
        mail.setLanguages(mailUpdate.getLanguages());
        mail.setPageSize(mailUpdate.getPageSize());
        mail.setSpamsFilter(mailUpdate.isSpamsFilter());
        mail.setSignature(mailUpdate.getSignature());
    }
}
