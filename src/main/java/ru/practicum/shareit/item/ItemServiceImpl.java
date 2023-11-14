package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.ItemStorage;
import ru.practicum.shareit.item.ItemDto;
import ru.practicum.shareit.item.ItemMapper;
import ru.practicum.shareit.item.ItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemStorage ist;

    @Override
    public ItemDto postItem(ItemDto itemDto, int userId) {

        itemDto.setOwnerId(userId);
        return ItemMapper.toItemDto(ist.postItem(ItemMapper.toItem(itemDto)));
    }

    @Override
    public ItemDto patchItem(int id, ItemDto itemDto) {


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
