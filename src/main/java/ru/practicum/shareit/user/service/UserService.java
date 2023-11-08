package ru.practicum.shareit.user.service;

import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.model.User;

import java.util.List;

public interface UserService {

    public User postUser(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public User putUser(User newUser);

    public List<User> deleteUserById(int id);
}
