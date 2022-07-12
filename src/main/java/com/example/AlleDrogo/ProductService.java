package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService{

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

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

    public void deleteProductById(String name){
        productRepository.deleteProductById(name);
    }

//    public Product findProductByName(String name){
//        return productRepository.findProductById(name).orElseThrow(() ->
//                new ProductNotFOundException("Product " + name + "doesn't exist"));
//    }

}
