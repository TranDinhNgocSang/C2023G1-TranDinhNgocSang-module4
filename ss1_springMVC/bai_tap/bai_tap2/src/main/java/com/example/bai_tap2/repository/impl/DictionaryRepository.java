package com.example.bai_tap2.repository.impl;

import com.example.bai_tap2.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("dog", "con chó");
        map.put("cat", "con mèo");
        map.put("birth", "con Chim");
        map.put("pig", "con heo");
    }

    public void putMap(String eng, String vn) {
        map.put(eng, vn);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
