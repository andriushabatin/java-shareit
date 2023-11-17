package ru.practicum.shareit.item;

import javax.validation.Valid;
import java.util.List;

public interface ItemStorage {

    public Item postItem(Item item);

    public Item patchItem(Item itemToPatch, int itemId);

    public Item getItemById(int itemId);

    public List<Item> getAllItemsByUserId(int userId);

    public List<Item> findItemsByText(String text);
}
