package com.example.giohang.service;

import com.example.giohang.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

    Product getProductById(Long id);
}