package ru.practicum.shareit.item;

import ru.practicum.shareit.item.ItemDto;
import ru.practicum.shareit.item.Item;

import java.util.List;

public interface ItemStorage {

    public Item postItem(Item item);

    public Item patchItem(int id);

    public Item getItemById(int id);

    public List<ItemDto> getAllItems();

    public List<ItemDto> findItemsByText();
}
