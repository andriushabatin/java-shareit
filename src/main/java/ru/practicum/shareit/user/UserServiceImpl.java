package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.exception.ValidationException;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStorage ust;

    @Override
    public UserDto postUser(@Valid UserDto userDto) {

        if (!ust.getAllUsers().isEmpty()) {
            if (ust.getAllUsers().stream().anyMatch(user -> user.getEmail().equals(userDto.getEmail()))) {
                throw new ValidationException("Email must be unique");
            }
        }
        return UserMapper.toUserDto(ust.postUser(UserMapper.toUser(userDto)));
    }

    @Override
    public UserDto getUserById(int id) {

        Optional<User> userToReturn = Optional.ofNullable(ust.getUserById(id));
        if (userToReturn.isEmpty()) {
            throw new NotFoundException("Не найден user по идентификатору:: " + id);
        }
        return UserMapper.toUserDto(userToReturn.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return ust.getAllUsers().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto patchUser(int userId, HashMap<String, Object> fields) {

        Optional<User> userToPatch = Optional.ofNullable(ust.getUserById(userId));

        if (userToPatch.isPresent()) {

            UserDto userDtoOfUserToPatch = UserMapper.toUserDto(userToPatch.get());
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(UserDto.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, userDtoOfUserToPatch, value);
            });

            deleteUserById(userId);
            if (getAllUsers().stream().anyMatch(user -> user.getEmail().equals(userDtoOfUserToPatch.getEmail()))) {
                ust.patchUser(userToPatch.get());
                throw new ValidationException("Email must be unique");
            }

            return UserMapper.toUserDto(ust.patchUser(UserMapper.toUser(userDtoOfUserToPatch)));

        } else {
            throw new RuntimeException("Не найден user по идентификатору:: " + userId);
        }
    }

    @Override
    public List<UserDto> deleteUserById(int id) {
        return ust.deleteUserById(id).stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
