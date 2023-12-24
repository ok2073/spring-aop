package com.keelient;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status) {
        //Logging
        //Authentication and Authorization
        //Sanitize the Data
        System.out.println("\nCheckout method from ShoppingCart called");
        System.out.println("Status: " + status);
    }

    public int quantity() {
        return 2;
    }
}
