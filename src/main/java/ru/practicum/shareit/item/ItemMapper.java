package ru.practicum.shareit.item;

import ru.practicum.shareit.item.ItemDto;
import ru.practicum.shareit.item.Item;

public class ItemMapper {

    public static ItemDto toItemDto(Item item) {

        return new ItemDto(item.getId(),
                item.getOwnerId(),
                item.getRequestId(),
                item.getName(),
                item.getDescription(),
                item.getIsAvailable()
                );
    }

    public static Item toItem(ItemDto itemDto) {

        return new Item(itemDto.getId(),
                itemDto.getOwnerId(),
                itemDto.getRequestId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getAvailable()
        );
    }
}

