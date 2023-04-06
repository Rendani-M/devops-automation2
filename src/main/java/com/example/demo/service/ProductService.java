package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){//Post method
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){//Post method
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){//Get method
        return repository.findAll();
    }

    public Product getProductById(int id){//Get method
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){//Get method
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return  "product removed !! "+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct= repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
