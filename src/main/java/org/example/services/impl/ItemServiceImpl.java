package org.example.services.impl;

import org.example.exceptions.NotFoundException;
import org.example.exceptions.WarningException;
import org.example.models.Item;
import org.example.repositories.ItemRepository;

public class ItemServiceImpl {
    private ItemRepository itemRepository;
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item){
        Item find = itemRepository.findItemByName(item.getName());
        if (find != null){
            try {
                throw new WarningException("Barang sudah tersedia, Gagal membuat barang baru");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        return itemRepository.createItem(item);
    }


}
