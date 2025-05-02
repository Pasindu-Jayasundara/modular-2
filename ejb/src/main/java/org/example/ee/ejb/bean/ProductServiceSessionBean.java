package org.example.ee.ejb.bean;

import jakarta.ejb.Stateless;
import org.example.ee.core.model.Product;
import org.example.ee.ejb.remote.ProductService;

import java.util.List;

@Stateless
public class ProductServiceSessionBean implements ProductService {

    @Override
    public Product getProductById(int productId) {
        return new Product(1,"Test Product","Test Description",1000.00,5);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1,"Test Product","Test Description",1000.00,5),
                new Product(2,"Test Product 2","Test Description 2",2000.00,8),
                new Product(3,"Test Product 3","Test Description 3",5000.00,4)
        );
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
