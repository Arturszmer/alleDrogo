package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductRepositoryTest {

    @Autowired ProductRepository productRepository;

    @BeforeEach
    public void setup(){
        productRepository.deleteAll();
    }

    @Test
    public void addNewProduct(){
    //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);

    //when
        productRepository.save(product1);
        productRepository.save(product2);

    //then
        List<Product> list = productRepository.findAll();
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void shouldShowAllProducts(){
    //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);

        //when
        productRepository.save(product1);
        productRepository.save(product2);
        int size = 2;
    //then
        List<Product> list = productRepository.findAll();
        assertThat(list.size()).isEqualTo(size);
    }

    @Test
    public void shouldFindProductByName(){
    //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
    //when
        productRepository.save(product1);
        productRepository.save(product2);
    //then
        Optional<Product> product = productRepository.findProductByName("Fender Stratocaster");
        assertThat(product.get().getName()).isEqualTo("Fender Stratocaster");
    }

    @Test
    public void shouldDeleteProductByName(){
    //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
        //when
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.deleteProductByName("Fender Stratocaster");
        int size = 1;
    //then
        List<Product> products = productRepository.findAll();
        assertThat(products.size()).isEqualTo(size);
    }




    }