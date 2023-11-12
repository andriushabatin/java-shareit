package ru.practicum.shareit.item.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.dao.ItemStorage;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InMemoryItemStorage implements ItemStorage {

    private final HashMap<Integer, Item> items;
    private int nextId = 1;

    @Override
    public Item postItem(Item item) {
        return null;
    }

    @Override
    public Item patchItem(int id) {
        return null;
    }

    @Override
    public Item getItemById(int id) {
        return null;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return null;
    }

    @Override
    public List<ItemDto> findItemsByText() {
        return null;
    }

    public int getNextId() {
        return nextId++;
    }
}
