package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Basket;
import com.example.AlleDrogo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Product> order = new ArrayList<>();

    public void addOrder(){
    }

    public List<Product> getOrders(){
        return Collections.unmodifiableList(order);
    }

}
