package com.example.bai_tap.repositoty.impl;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.repositoty.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Iphone", 2000, "good", "USA"));
        productList.add(new Product(2, "pc", 3000, "good", "VN"));
        productList.add(new Product(3, "lap", 1000, "good", "CHINA"));
        productList.add(new Product(4, "key", 200, "good", "USA"));
        productList.add(new Product(5, "tab", 1000, "good", "VN "));
    }

    private static int size = productList.size();

    @Override
    public List<Product> getListProduct() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        size = size + 1;
        product.setId(size);
        productList.add(product);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product getProductById(int id) {
        int index = findIndexById(id);
       return productList.get(index);
    }

    @Override
    public void updateProduct(Product product) {
        int index = findIndexById(product.getId());
        productList.get(index).setName(product.getName());
        productList.get(index).setPrice(product.getPrice());
        productList.get(index).setDescribe(product.getDescribe());
        productList.get(index).setManufacture(product.getManufacture());
    }

    @Override
    public void deleteProduct (int id) {
        int index = findIndexById(id);
        productList.remove(index);
    }

    @Override
    public List<Product> searchProduct(String name) {
        if (name==null){
            name = "";
        }
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)){
                list.add(productList.get(i));
            }
        }
        return list;
    }
}
