package com.example.AlleDrogo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private String name;
    private String description;
    private double price;
    private String imgUrl;

    @JsonCreator
    public Product(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(){

    }

    public Product(Product product) {
        this.name = getName();
        this.description = getDescription();
        this.price = getPrice();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
