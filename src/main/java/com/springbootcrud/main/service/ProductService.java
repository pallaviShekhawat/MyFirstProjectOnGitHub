package com.springbootcrud.main.service;

import java.util.List;
import java.util.Optional;

import com.springboot.main.entity.Product;


public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    Product getProductById(long productId);

    Optional<Product> deleteProduct(long id);
}
