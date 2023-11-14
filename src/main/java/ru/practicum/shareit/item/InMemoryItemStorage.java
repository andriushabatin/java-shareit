package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.ItemStorage;
import ru.practicum.shareit.item.ItemDto;
import ru.practicum.shareit.item.Item;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InMemoryItemStorage implements ItemStorage {

    private final HashMap<Integer, Item> items;
    private int nextId = 1;

    @Override
    public Item postItem(Item item) {

        item.setId(getNextId());
        items.put(item.getId(), item);
        return getItemById(item.getId());
    }

    @Override
    public Item patchItem(int id) {
        return null;
    }

    @Override
    public Item getItemById(int id) {
        return items.get(id);
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
