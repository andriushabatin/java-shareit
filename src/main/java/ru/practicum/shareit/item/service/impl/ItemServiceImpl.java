package ru.practicum.shareit.item.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.dao.ItemStorage;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.service.ItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemStorage ist;

    @Override
    public ItemDto postItem(ItemDto itemDto) {
        return null;
    }

    @Override
    public ItemDto patchItem(int id) {
        return null;
    }

    @Override
    public ItemDto getItemById(int id) {
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
}
