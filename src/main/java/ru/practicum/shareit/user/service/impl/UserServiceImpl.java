package ru.practicum.shareit.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.dao.UserStorage;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStorage ust;

    @Override
    public User postUser(User user) {
        return ust.postUser(user);
    }

    @Override
    public User getUserById(int id) {
        return ust.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return ust.getAllUsers();
    }

    @Override
    public User putUser(User user) {
        return ust.putUser(user);
    }

    @Override
    public List<User> deleteUserById(int id) {
        return ust.deleteUserById(id);
    }
}
