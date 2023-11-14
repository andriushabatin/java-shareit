package ru.practicum.shareit.item;

import ru.practicum.shareit.item.ItemDto;

import java.util.List;

public interface ItemService {

    public ItemDto postItem(ItemDto itemDto, int UserId);

    public ItemDto patchItem(int id, ItemDto itemDto);

    public ItemDto getItemById(int id);

    public List<ItemDto> getAllItems();

    public List<ItemDto> findItemsByText();
}
