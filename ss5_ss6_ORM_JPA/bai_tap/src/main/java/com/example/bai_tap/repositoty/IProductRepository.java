package com.example.bai_tap.repositoty;

import com.example.bai_tap.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getListProduct();

    void addProduct(Product product);
//
//    int findIndexById(int id);
//
    Product getProductById(int id);

    void updateProduct(Product product);

    void deleteProduct (int id);

    List<Product> searchProduct (String name);
}
