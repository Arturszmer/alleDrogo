package com.example.AlleDrogo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private final List<Product> productsInOrder = new ArrayList<>();

    private final String shipmentAddress;

    public Order(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }





}
