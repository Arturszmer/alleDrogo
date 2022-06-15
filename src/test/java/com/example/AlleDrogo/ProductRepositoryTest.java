package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductRepositoryTest {

    @Autowired ProductRepository productRepository;


    @Test
    public void addNewProduct(){
    //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);

    //when
        productRepository.addProduct(product1);
        productRepository.addProduct(product2);

    //then
        List<Product> list = productRepository.getAllProducts();
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void nameOfTest(){
    //given

    //when

    //then
    }


}