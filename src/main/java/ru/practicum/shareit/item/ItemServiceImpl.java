package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import ru.practicum.shareit.exception.ValidationException;
import ru.practicum.shareit.user.UserDto;
import ru.practicum.shareit.user.UserService;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemStorage ist;
    private final UserService us;

    @Override
    public ItemDto postItem(@Valid ItemDto itemDto, int userId) {

        UserDto ownerDto = us.getUserById(userId);
        return ItemMapper.toItemDto(ist.postItem(ItemMapper.toItem(itemDto, userId)));
    }

    @Override
    public ItemDto patchItem(HashMap<String, Object> fields, int itemId, int userId) {

        Optional<Item> itemToPatch = Optional.ofNullable(ist.getItemById(itemId));

        if (itemToPatch.isPresent()) {

            ItemDto dtoOfItemToPatch = ItemMapper.toItemDto(itemToPatch.get());
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(ItemDto.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, dtoOfItemToPatch, value);
            });

            if (itemToPatch.get().getOwnerId() != userId) {
                throw new ValidationException("User с идентификатором " + userId + " не может редактировать этот item");
            }

            return ItemMapper.toItemDto(ist.patchItem(ItemMapper.toItem(dtoOfItemToPatch, userId)));

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

        if (text.isBlank()) {
            return new ArrayList<>();
        }

        return ist.findItemsByText(text.toLowerCase())
                .stream()
                .filter(Item::getAvailable)
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }
}
