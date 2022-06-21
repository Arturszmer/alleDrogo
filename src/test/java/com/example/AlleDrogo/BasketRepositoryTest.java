package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Basket;
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
class BasketRepositoryTest {

    @Autowired
    BasketRepository basketRepository;

    @Test
    public void shouldRemoveSpecificProductFromBasket() {
        //given
        Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
        Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
        //when
        basketRepository.addToBasket(product1);
        basketRepository.addToBasket(product2);
        //then
        List<Product> list = basketRepository.getBasket();
        basketRepository.removeFromBasket(product1);
        assertThat(list.size()).isEqualTo(1);
    }
        @Test
        public void shouldShowAllProductsFromBasket(){
            //given
            Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);

            //when
            basketRepository.addToBasket(product1);

            //then
            List<Product> list = basketRepository.getBasket();
            assertThat(list.size()).isEqualTo(1);
        }

    }