package ru.practicum.shareit.item;

import ru.practicum.shareit.item.ItemDto;

import java.util.HashMap;
import java.util.List;

public interface ItemService {

    public ItemDto postItem(ItemDto itemDto, int userId);

    public ItemDto patchItem(HashMap<String, Object> fields, int id, int userId);

    public ItemDto getItemById(int itemId);

    public List<ItemDto> getAllItemsByUserId(int userId);

    public List<ItemDto> findItemsByText(String text);
}
