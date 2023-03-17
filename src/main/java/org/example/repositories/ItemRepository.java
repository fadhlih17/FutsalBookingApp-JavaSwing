package org.example.repositories;

import org.example.models.Item;

import java.util.List;

public interface ItemRepository {
    Item createItem(Item item);
    boolean updateItem(Item item);
    List<Item> findAllItem();
    boolean deleteItem(String name);
}
