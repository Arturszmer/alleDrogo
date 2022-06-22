package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Order;
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
class BasketRepositoryTest {

    @Autowired
    BasketRepository basketRepository;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    public void setup(){
        basketRepository.clear();
    }

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

        @Test
        public void shoudConfirmBasket(){
        //given
            Product product1 = new Product("Fender Stratocaster", "Gitara elektryczna", 3500);
            Product product2 = new Product("Gibson Les Paul", "Gitara elektryczna", 5000);
            basketRepository.addToBasket(product1);
            basketRepository.addToBasket(product2);
            List<Product> list = basketRepository.getBasket();

            //when
            Order list1 = basketRepository.confirmBasket("Sosnowiec");
        //then
            assertThat(list1.getProductsInOrder().size()).isEqualTo(2);
            assertThat(list1.getShipmentAddress()).isEqualTo("Sosnowiec");
            assertThat(basketRepository.getBasket()).isEmpty();
        }




    }