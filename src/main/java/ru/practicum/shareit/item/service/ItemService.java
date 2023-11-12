package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;

import java.util.List;

public interface ItemService {

    public ItemDto postItem(ItemDto itemDto);

    public ItemDto patchItem(int id);

    public ItemDto getItemById(int id);

    public List<ItemDto> getAllItems();

    public List<ItemDto> findItemsByText();
}
