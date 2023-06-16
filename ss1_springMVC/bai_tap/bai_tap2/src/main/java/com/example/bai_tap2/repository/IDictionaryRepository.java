package com.example.bai_tap2.repository;

import java.util.Map;

public interface IDictionaryRepository {
    void putMap(String eng, String vn);

    Map<String, String> getMap();
}
