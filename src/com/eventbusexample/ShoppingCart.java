package com.eventbusexample;

import java.util.UUID;


public class ShoppingCart {

    private final EventBus eventBus;
    private final CartRepository cartRepository;

    public ShoppingCart(EventBus eventBus, CartRepository cartRepository) {
        this.eventBus = eventBus;
        this.cartRepository = cartRepository;
    }

    public UUID addItem(Item item, User user) {
        UUID itemId = cartRepository.addItem(item, user);
        eventBus.post(new ItemAddedEvent(item, user));
        return itemId;
    }

    class ItemAddedEvent {
        private final Item item;
        private final User user;

        ItemAddedEvent(Item item, User user) {
            this.item = item;
            this.user = user;
        }
    }
}
