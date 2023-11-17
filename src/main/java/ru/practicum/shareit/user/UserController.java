package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.exception.ValidationException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

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
    public String handleMethodArgumentNotValidException(final ConstraintViolationException e) {
        return "error";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleMethodArgumentNotValidException(final ValidationException e) {
        return e.getMessage();
    }

}

