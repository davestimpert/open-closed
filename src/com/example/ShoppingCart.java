package com.example;

import java.util.List;
import java.util.UUID;


public abstract class ShoppingCart {

    private final CartRepository cartRepository;
    private final Inventory inventory;
    private final Promotions promotions;

    public ShoppingCart(CartRepository cartRepository, Inventory inventory, Promotions promotions) {
        this.cartRepository = cartRepository;
        this.inventory = inventory;
        this.promotions = promotions;
    }

    public UUID addItem(Item item, User user) {
        inventory.decrement(item.getSku(), item.getQty());
        UUID uuid = cartRepository.addItem(item, user);
        promotions.checkForPromotions(getItems());
        return uuid;
    }

    abstract List<Long> getItems();

}
