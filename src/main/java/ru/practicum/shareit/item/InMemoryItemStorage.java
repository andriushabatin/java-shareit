package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import ru.practicum.shareit.item.ItemStorage;
import ru.practicum.shareit.item.ItemDto;
import ru.practicum.shareit.item.Item;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public Item patchItem(Item itemToPatch, int itemId) {

        items.put(itemId, itemToPatch);
        return getItemById(itemId);
    }

    @Override
    public Item getItemById(int itemId) {

        return items.get(itemId);
    }

    @Override
    public List<Item> getAllItemsByUserId(int userId) {

        return items.values()
                .stream()
                .filter(user -> user.getOwnerId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findItemsByText(String text) {

        return items.values()
                .stream()
                .filter(user -> user.getName().toLowerCase().contains(text)
                        || user.getDescription().toLowerCase().contains(text))
                .collect(Collectors.toList());
    }

    public int getNextId() {
        return nextId++;
    }
}
