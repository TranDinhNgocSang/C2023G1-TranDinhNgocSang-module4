package com.example.bai_tap.service;

import com.example.bai_tap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getListProduct();

    void addProduct(Product product);

    Product getProductById(int id);

    void updateProduct(Product product);
}

