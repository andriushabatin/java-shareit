package ru.practicum.shareit.user;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

public interface UserService {

    public UserDto postUser(@Valid UserDto userDto);

    public UserDto getUserById(int id);

    public List<UserDto> getAllUsers();

    public UserDto patchUser(int userId, HashMap<String, Object> fields);

    public List<UserDto> deleteUserById(int id);
}
