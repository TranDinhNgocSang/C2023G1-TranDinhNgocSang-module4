package com.example.giohang.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }


    private boolean checkItemInCart(Product product) {
        for (Product p : products.keySet()) {
            if (p.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public void addProductt(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            int num = 0;
            for (Product p : products.keySet()) {
                if (p.equals(product)) {
                    num = products.get(p);
                }
            }
            products.replace(product, num + 1);
        }
    }

    public void subProductt(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            int num = 0;
            for (Product p : products.keySet()) {
                if (p.equals(product)) {
                    num = products.get(p);
                }
            }
            if (num == 1) {
                products.remove(product, num);
            } else {
                products.replace(product, num - 1);
            }

        }
    }

    public Integer countProductQuantityy() {
        Integer productQuantity = 0;
        for (Product p : products.keySet()) {
            productQuantity += products.get(p);
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPaymentt() {
        float payment = 0;
        for (Product p : products.keySet()) {
            payment += p.getPrice() * (float) products.get(p);
        }
        return payment;
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }


//   ==================== Dùng Entry (cặp key - value)==================

//        private boolean checkItemInCartt(Product product) {
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            if (entry.getKey().getId().equals(product.getId())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            if (entry.getKey().getId().equals(product.getId())) {
//                return entry;
//            }
//        }
//        return null;
//    }
//
//    private Map.Entry<Product, Integer> selectItemInCartt(Product product) {
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            if (entry.getKey().getId().equals(product.getId())) {
//                return entry;
//            }
//        }
//        return null;
//    }
//
//        public void addProduct(Product product) {
//        if (!checkItemInCart(product)) {
//            products.put(product, 1);
//        } else {
//            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
//            Integer newQuantity = itemEntry.getValue() + 1;
//            products.replace(itemEntry.getKey(), newQuantity);
//        }
//    }
//
//        public void subProduct(Product product) {
//        if (!checkItemInCart(product)) {
//            products.put(product, 1);
//        } else {
//            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
//            Integer newQuantity = itemEntry.getValue() - 1;
//            if (newQuantity ==0){
//                products.remove(itemEntry.getKey(),itemEntry.getValue());
//            }else {
//                products.replace(itemEntry.getKey(), newQuantity);
//            }
//
//        }
//    }
//
//        public Integer countProductQuantity() {
//        Integer productQuantity = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            productQuantity += entry.getValue();
//        }
//        return productQuantity;
//    }
//
//        public Float countTotalPayment() {
//        float payment = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;
//    }
//
//    public Integer countProductQuantityy() {
//        Integer productQuantity = 0;
//        for (Product p : products.keySet()) {
//            productQuantity += products.get(p);
//        }
//        return productQuantity;
//    }

}
