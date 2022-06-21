package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Basket;
import com.example.AlleDrogo.model.Order;
import com.example.AlleDrogo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class BasketRepository {

    private final List<Product> basket = new ArrayList<>();


    public void addToBasket(Product product){
        basket.add(product);
    }

    public void removeFromBasket(Product product){
        basket.remove(product);
    }

    public List<Product> getBasket(){
        return Collections.unmodifiableList(basket);
    }

    void confirmBasket(){

    }



}
