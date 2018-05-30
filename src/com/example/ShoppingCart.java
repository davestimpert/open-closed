package com.example;

import java.util.UUID;


public class ShoppingCart {

    private final CartRepository cartRepository;
    private final Inventory inventory;

    public ShoppingCart(CartRepository cartRepository, Inventory inventory) {
        this.cartRepository = cartRepository;
        this.inventory = inventory;
    }

    public UUID addItem(Item item, User user) {
        inventory.decrement(item.getSku(), item.getQty());
        return cartRepository.addItem(item, user);
    }

}
