package ru.practicum.shareit.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * TODO Sprint add-controllers.
 */
@Data
@Builder
@AllArgsConstructor
public class ItemDto {

    private Integer id;
    private Integer ownerId;
    private Integer requestId;
    //////////////////////////
    private String name;
    private String description;
    private Boolean available;
}
