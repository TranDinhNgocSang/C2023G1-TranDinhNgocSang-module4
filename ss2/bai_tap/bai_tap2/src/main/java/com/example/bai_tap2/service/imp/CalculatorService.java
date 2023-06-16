package com.example.bai_tap2.service.imp;

import com.example.bai_tap2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double summation(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double Subtraction(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double division(double num1, double num2) {
        return num1 / num2;
    }
}
