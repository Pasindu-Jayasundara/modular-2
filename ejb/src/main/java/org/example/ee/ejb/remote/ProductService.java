package org.example.ee.ejb.remote;

import jakarta.ejb.Remote;
import org.example.ee.core.model.Product;

import java.util.List;

@Remote
public interface ProductService {

    Product getProductById(int productId);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
