package com.example.bai_tap2.service.impl;

import com.example.bai_tap2.repository.impl.DictionaryRepository;
import com.example.bai_tap2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;


    @Override
    public void putMap(String eng, String vn) {
        dictionaryRepository.putMap(eng, vn);
    }

    @Override
    public String search(String eng) {
        Map<String, String> map = dictionaryRepository.getMap();
        for (String s : map.keySet()) {
            if (s.equals(eng)) {
                return map.get(s);
            }
        }
        return "không có trong từ điển";
    }

}
