package com.example.bai_tap1.service.impl;

import com.example.bai_tap1.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public double changeMoney(double usd) {
        return usd*24000;
    }
}
