package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService is;

    private static final String USER_ID_HEADER = "X-Sharer-User-Id";

    @PostMapping
    public ItemDto postItem(@RequestBody ItemDto itemDto, @RequestHeader(USER_ID_HEADER) int userId) {
        return is.postItem(itemDto, userId);
    }

    @PatchMapping("/{itemId}")
    public ItemDto patchItem(@RequestBody HashMap<String, Object> fields,
                             @PathVariable int itemId,
                             @RequestHeader(USER_ID_HEADER) int userId) {
        return is.patchItem(fields, itemId, userId);
    }

    @GetMapping("/{itemId}")
    public ItemDto getItemById(@PathVariable int itemId) {
        return is.getItemById(itemId);
    }

    @GetMapping
    public List<ItemDto> getAllItemsByUserId(@RequestHeader(USER_ID_HEADER) int userId) {
        return is.getAllItemsByUserId(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> findItemsByText(@RequestParam String text) {
        return is.findItemsByText(text);
    }
}
