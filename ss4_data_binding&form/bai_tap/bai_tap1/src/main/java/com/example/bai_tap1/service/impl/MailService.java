package com.example.bai_tap1.service.impl;

import com.example.bai_tap1.model.Mail;
import com.example.bai_tap1.repository.impl.MailRepository;
import com.example.bai_tap1.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    MailRepository mailRepository;

    @Override
    public List<String> getLanguages() {
        return mailRepository.getLanguages();
    }

    @Override
    public List<Integer> getPageSizes() {
        return mailRepository.getPageSizes();
    }

    @Override
    public Mail getMail() {
        return mailRepository.getMail();
    }

    @Override
    public void update(Mail mail) {
        mailRepository.update(mail);
    }
}
