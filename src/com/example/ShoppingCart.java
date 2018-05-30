package com.example;

import java.util.UUID;


public class ShoppingCart {

    private final CartRepository cartRepository;

    public ShoppingCart(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public UUID addItem(Item item, User user) {
        return cartRepository.addItem(item, user);
    }

}
