package com.example.AlleDrogo.model;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Product> copy(List<Product> products){
        List<Product> clone = new ArrayList<Product>(products.size());
        for (Product product : products) {
            clone.add(new Product(product));
        }
        return clone;
    }

}
