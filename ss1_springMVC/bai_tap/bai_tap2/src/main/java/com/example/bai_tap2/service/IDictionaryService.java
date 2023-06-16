package com.example.bai_tap2.service;

import java.util.Map;

public interface IDictionaryService {
    void putMap(String eng, String vn);

    String search(String eng);
}
