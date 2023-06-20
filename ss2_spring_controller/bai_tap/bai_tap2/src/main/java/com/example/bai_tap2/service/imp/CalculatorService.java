package com.example.bai_tap2.service.imp;

import com.example.bai_tap2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(double num1, double num2, String math) {
        switch (math) {
            case "summation":
                return String.valueOf(num1 + num2);
            case "Subtraction":
                return String.valueOf(num1 - num2);
            case "multiplication":
                return String.valueOf(num1 * num2);
            case "division":
                if (num2 == 0){
                    return "lỗi chia cho 0";
                }else {
                    return String.valueOf(num1 / num2);
                }
        }
        return null;
    }
}
