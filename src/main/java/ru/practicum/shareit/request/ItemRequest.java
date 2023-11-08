package ru.practicum.shareit.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * TODO Sprint add-item-requests.
 */

@Data
public class ItemRequest {

    //id — уникальный идентификатор запроса;
    //description — текст запроса, содержащий описание требуемой вещи; requestor — пользователь, создавший запрос;
    //created — дата и время создания запроса.
    Integer id;
    String description;
    LocalDateTime created;
}
