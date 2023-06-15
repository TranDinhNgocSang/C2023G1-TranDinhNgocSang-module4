package com.example.bai_tap1.service.impl;

import com.example.bai_tap1.service.IBangTinhService;
import org.springframework.stereotype.Service;

@Service
public class BangTinhService implements IBangTinhService {

    @Override
    public double doiTien(double usd) {
        return usd*24000;
    }
}
