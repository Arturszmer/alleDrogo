package com.example.AlleDrogo.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Product> productsInOrder = new ArrayList<>();

    private final String shipmentAddress;

    public Order(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public void addOrderProducts(List<Product> products){
        productsInOrder.addAll(products);
    }

    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productsInOrder=" + productsInOrder +
                ", shipmentAddress='" + shipmentAddress + '\'' +
                '}';
    }

    // konstruktor kopiujący






}
