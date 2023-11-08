package ru.practicum.shareit.item.model;

import lombok.Data;

/**
 * TODO Sprint add-controllers.
 */

@Data
public class Item {

    //В пакете item создайте класс Item и добавьте в него следующие поля: id — уникальный идентификатор вещи;
    //name — краткое название;
    //description — развёрнутое описание;
    //available — статус о том, доступна или нет вещь для аренды;
    //owner — владелец вещи;
    //request — если вещь была создана по запросу другого пользователя, то в этом поле будет храниться ссылка
    // на соответствующий запрос.
    Integer id;
    Integer ownerId;
    Integer requestId;
    String name;
    String description;
    Boolean isAvailable;
}
