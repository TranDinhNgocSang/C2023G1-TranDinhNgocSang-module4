package com.example.bai_tap2.service.impl;

import com.example.bai_tap2.repository.ITuDienRepository;
import com.example.bai_tap2.repository.impl.TuDienRepository;
import com.example.bai_tap2.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TuDienService implements ITuDienService {
    @Autowired
    private TuDienRepository tuDienRepository;


    @Override
    public void putMap(String eng, String vn) {
        tuDienRepository.putMap(eng, vn);
    }

    @Override
    public String search(String eng) {
        Map<String, String> map = tuDienRepository.getMap();
        for (String s : map.keySet()) {
            if (s.equals(eng)) {
                return map.get(s);
            }
        }
        return "không có trong từ điển";
    }

}
