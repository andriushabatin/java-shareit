package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ItemDto postItem(@RequestBody ItemDto itemDto, @RequestHeader("X-Sharer-User-Id") int userId) {
        return is.postItem(itemDto, userId);
    }

    @PatchMapping("/{id}")
    public ItemDto patchItem(@PathVariable int id, @RequestBody ItemDto itemdto) {
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
