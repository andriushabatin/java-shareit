package ru.practicum.shareit.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.service.UserService;

import java.util.ArrayList;
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
    public User postUser(@RequestBody User user) {
        return us.postUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return us.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    @PutMapping
    public User putUser(@RequestBody User user) {
        return us.putUser(user);
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUserById(@PathVariable int id) {
        return us.deleteUserById(id);
    }
}

