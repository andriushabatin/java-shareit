package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.exception.ValidationException;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Sprint add-controllers.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService us;

    @PostMapping
    public UserDto postUser(@RequestBody UserDto userDto) {
        return us.postUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return us.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return us.getAllUsers();
    }

    @PatchMapping("/{userId}")
    public UserDto patchUser(@PathVariable int userId, @RequestBody HashMap<String, Object> fields) {
        return us.patchUser(userId, fields);
    }

    @DeleteMapping("/{id}")
    public List<UserDto> deleteUserById(@PathVariable int id) {
        return us.deleteUserById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentNotValidException(final ConstraintViolationException e) {
        return Map.of("error:", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleMethodArgumentNotValidException(final ValidationException e) {
        return Map.of("error:", e.getMessage());
    }

}

