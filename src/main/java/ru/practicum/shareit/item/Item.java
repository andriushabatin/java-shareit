package ru.practicum.shareit.item;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO Sprint add-controllers.
 */

@Data
@AllArgsConstructor
public class Item {

    Integer id;
    Integer ownerId;
    Integer requestId;
    String name;
    String description;
    Boolean isAvailable;
}
