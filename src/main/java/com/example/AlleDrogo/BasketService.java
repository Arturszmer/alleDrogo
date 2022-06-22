package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Order;
import com.example.AlleDrogo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final OrderRepository orderRepository;

    public BasketService(BasketRepository basketRepository, OrderRepository orderRepository) {
        this.basketRepository = basketRepository;
        this.orderRepository = orderRepository;
    }

    void addProduct(Product product){
        basketRepository.addToBasket(product);
    }
    void removeProduct(Product product){
        basketRepository.removeFromBasket(product);
    }
    List<Product> getBasket(){
        return Collections.unmodifiableList(basketRepository.getBasket());
    }

    public void confirmBasket(String shipmentAddress, List<Product> products) {

        basketRepository.confirmBasket(shipmentAddress);
    }
}