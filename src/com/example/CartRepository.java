package com.example;

import java.util.UUID;

public interface CartRepository {
	UUID addItem(Item item, User user);
}
