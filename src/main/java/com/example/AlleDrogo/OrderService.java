package com.example.AlleDrogo;

import com.example.AlleDrogo.model.Product;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(List<Product> productsFromBasker){
        orderRepository.addOrder(productsFromBasker);
    }
    public List<Product> getOrders(){
        return orderRepository.getOrders();
    }

}
