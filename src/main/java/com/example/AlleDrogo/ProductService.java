package com.example.AlleDrogo;

import com.example.AlleDrogo.exceptions.ProductNotFOundException;
import com.example.AlleDrogo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product addSpecProd(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProductByName(String name){
        productRepository.deleteProductByName(name);
    }

    public Product findProductByName(String name){
        return productRepository.findProductByName(name).orElseThrow(() ->
                new ProductNotFOundException("Product " + name + "doesn't exist"));
    }

}
