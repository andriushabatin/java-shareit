package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
}

