package com.eventbusexample;

import java.util.UUID;

public interface CartRepository {
	UUID addItem(Item item, User user);
}
