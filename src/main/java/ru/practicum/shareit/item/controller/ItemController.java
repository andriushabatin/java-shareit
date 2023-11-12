package ru.practicum.shareit.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.service.ItemService;

import java.util.List;

/**
 * TODO Sprint add-controllers.
 */
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService is;

    @PostMapping
    public ItemDto postItem(ItemDto itemDto) {
        return null;
    }

    @PatchMapping("/{id}")
    public ItemDto patchItem(int id) {
        return null;
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(int id) {
        return null;
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return null;
    }

    @GetMapping("/search")
    public List<ItemDto> findItemsByText() {
        return null;
    }


}
