package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Order;
import com.example.AlleDrogo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    Order confirmBasket(String shipmentAdres){
        Order order = new Order(shipmentAdres);
        order.addOrderProducts(copy(basket));
        basket.clear();
        return order;
    }


    public static List<Product> copy(List<Product> products) {
        List<Product> clone = new ArrayList<>(products.size());
        for (Product product : products) {
            clone.add(new Product(product));
        }
        return clone;
    }
}
