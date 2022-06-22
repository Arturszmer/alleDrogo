package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Order;
import com.example.AlleDrogo.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private final List<Product> order = new ArrayList<>();

    public void addOrder(List<Product> productsFromBasket){
        order.addAll(productsFromBasket);
    }

    public List<Product> getOrders(){
        return Collections.unmodifiableList(order);
    }
}
