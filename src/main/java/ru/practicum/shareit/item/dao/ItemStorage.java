package ru.practicum.shareit.item.dao;

import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

import java.util.List;

public interface ItemStorage {

    public Item postItem(Item item);

    public Item patchItem(int id);

    public Item getItemById(int id);

    public List<ItemDto> getAllItems();

    public List<ItemDto> findItemsByText();
}
