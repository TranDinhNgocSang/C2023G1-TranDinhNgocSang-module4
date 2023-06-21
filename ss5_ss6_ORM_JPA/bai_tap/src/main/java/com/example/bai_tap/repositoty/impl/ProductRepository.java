package com.example.bai_tap.repositoty.impl;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.repositoty.ConnectionUtils;
import com.example.bai_tap.repositoty.IProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> getListProduct() {
        return ConnectionUtils.getEntityManager().createQuery("SELECT P FROM Product AS P").getResultList();
    }

    @Override
    public void addProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction !=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
//
//    @Override
//    public int findIndexById(int id) {
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getId()==id){
//                return i;
//            }
//        }
//        return -1;
//    }
//
    @Override
    public Product getProductById(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();    }

    @Override
    public void updateProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product productOne = getProductById(product.getId());
            productOne.setName(product.getName());
            productOne.setPrice(product.getPrice());
            productOne.setDescribeProduct(product.getDescribeProduct());
            productOne.setManufacture(product.getManufacture());
            session.update(productOne);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction !=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct (int id) {
        Product product = getProductById(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction !=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Product> searchProduct(String name) {
        String queryStr = "SELECT p FROM Product AS p where p.name LIKE concat('%',:name,'%') ";
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().createQuery(queryStr, Product.class);
        query.setParameter("name", name);
        return query.getResultList();
        }
    }

