package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BasketServiceTest {

    @Autowired
    BasketService basketService;

    @Test
    void shouldAddToBasket(){
        //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
        //when
        basketService.addProduct(product1);
        basketService.addProduct(product2);
        //then
        List<Product> basket = basketService.getBasket();
        assertThat(basket.size()).isEqualTo(2);
    }
    @Test
    void shouldRemoveFromBasket(){
        //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
        //when
        basketService.addProduct(product1);
        basketService.addProduct(product2);
        //then
        List<Product> basket = basketService.getBasket();
        basketService.removeProduct(product2);
        assertThat(basket.size()).isEqualTo(1);
    }
    @Test
    void shouldConfirmBasket(){
        //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
        basketService.addProduct(product1);
        basketService.addProduct(product2);
        //when
        List<Product> basket = basketService.getBasket();
        basketService.confirmBasket("aafw", basket);

        //then
        assertThat(basket.size()).isEqualTo(2);

    }
}