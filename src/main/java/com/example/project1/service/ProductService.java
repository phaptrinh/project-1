package com.example.project1.service;

import com.example.project1.entity.Product;
import com.example.project1.exception.NotFoundException;
import com.example.project1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        req -> pro
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product getProductById(int id) throws NotFoundException {
        Product p = productRepository.findById(id).orElse(null);
        if (p == null) throw new NotFoundException("Không tồn tại");
        else return p;
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product with ID: " + id + " have been removed!";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
