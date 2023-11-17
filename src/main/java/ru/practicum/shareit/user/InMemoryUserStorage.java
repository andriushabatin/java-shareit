package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Validated
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
    public User patchUser(@Valid User userToPatch) {

        /*if (!getAllUsers().isEmpty()) {

            User oldUser = getUserById(userId);
            deleteUserById(userId);

            if (getAllUsers().stream().anyMatch(user -> user.getEmail().equals(userToPatch.getEmail()))) {
                users.put(userId, oldUser);
                throw new ValidationException("Email must be unique");
            }
        }*/
        users.put(userToPatch.getId(), userToPatch);
        return getUserById(userToPatch.getId());
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
