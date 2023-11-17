package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemStorage ist;

    @Override
    public ItemDto postItem(ItemDto itemDto, int userId) {
        return ItemMapper.toItemDto(ist.postItem(ItemMapper.toItem(itemDto, userId)));
    }

    @Override
    public ItemDto patchItem(HashMap<String, Object> fields, int itemId, int userId) {

        Optional<Item> itemToPatch = Optional.ofNullable(ist.getItemById(itemId));

        if (itemToPatch.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Item.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, itemToPatch.get(), value);
            });
            return ItemMapper.toItemDto(ist.patchItem(itemToPatch.get(), itemId));
        } else {
            throw new RuntimeException("Не найден user по идентификатору:: " + userId);
        }
    }

    @Override
    public ItemDto getItemById(int itemId) {
        return ItemMapper.toItemDto(ist.getItemById(itemId));
    }

    @Override
    public List<ItemDto> getAllItemsByUserId(int userId) {

        return ist.getAllItemsByUserId(userId)
                .stream()
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> findItemsByText(String text) {

        return ist.findItemsByText(text.toLowerCase())
                .stream()
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }
}
