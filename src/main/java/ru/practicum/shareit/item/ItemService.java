package ru.practicum.shareit.item;

import ru.practicum.shareit.exception.ValidationException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

public interface ItemService {

    public ItemDto postItem(@Valid ItemDto itemDto, int userId);

    public ItemDto patchItem(HashMap<String, Object> fields, int id, int userId) throws ValidationException;

    public ItemDto getItemById(int itemId);

    public List<ItemDto> getAllItemsByUserId(int userId);

    public List<ItemDto> findItemsByText(String text);
}
