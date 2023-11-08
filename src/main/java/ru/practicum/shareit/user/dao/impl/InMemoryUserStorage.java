package ru.practicum.shareit.user.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.dao.UserStorage;
import ru.practicum.shareit.user.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InMemoryUserStorage implements UserStorage {

    private final HashMap<Integer, User> users;
    private int nextId = 1;

    @Override
    public User postUser(User user) {

        user.setId(getNextId());
        users.put(user.getId(), user);
        return getUserById(user.getId());
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User putUser(User user) {

        users.put(user.getId(), user);
        return getUserById(user.getId());
    }

    @Override
    public List<User> deleteUserById(int id) {

        users.remove(id);
        return getAllUsers();
    }

    public int getNextId() {
        return nextId++;
    }
}
