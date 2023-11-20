package ru.practicum.shareit.item;

import java.util.List;

public interface ItemStorage {

    public Item postItem(Item item);

    public Item patchItem(Item itemToPatch);

    public Item getItemById(int itemId);

    public List<Item> getAllItemsByUserId(int userId);

    public List<Item> findItemsByText(String text);
}
