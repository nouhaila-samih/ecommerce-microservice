package net.nouha.billingservice.model;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
