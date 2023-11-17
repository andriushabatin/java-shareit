package ru.practicum.shareit.user;

import javax.validation.Valid;
import java.util.List;

public interface UserStorage {

    public User postUser(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    User patchUser(@Valid User userToPatch);

    public List<User> deleteUserById(int id);


}
