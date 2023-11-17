package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.exception.ValidationException;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PatchMapping("/{itemId}")
    public ItemDto patchItem(@RequestBody HashMap<String, Object> fields,
                             @PathVariable int itemId,
                             @RequestHeader("X-Sharer-User-Id") int userId) {
        return is.patchItem(fields, itemId, userId);
    }

    @GetMapping("/{itemId}")
    public ItemDto getItemById(@PathVariable int itemId) {
        return is.getItemById(itemId);
    }

    @GetMapping
    public List<ItemDto> getAllItemsByUserId(@RequestHeader("X-Sharer-User-Id") int userId) {
        return is.getAllItemsByUserId(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> findItemsByText(@RequestParam String text) {
        return is.findItemsByText(text);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(final NotFoundException e) {
        return Map.of("error:", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleMethodArgumentNotValidException(final ValidationException e) {
        return Map.of("error:", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentNotValidException(final ConstraintViolationException e) {
        return Map.of("error:", e.getMessage());
    }
}
