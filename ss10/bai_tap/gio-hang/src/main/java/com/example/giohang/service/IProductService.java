package com.example.giohang.service;

import com.example.giohang.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

}