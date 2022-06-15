package com.example.AlleDrogo.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Product> basketProducts = new ArrayList<>();

    public List<Product> getAllBasketProducts() {
        return basketProducts;
    }

    public void addProduct(Product product){
        basketProducts.add(product);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "products=" + basketProducts +
                '}';
    }

}
