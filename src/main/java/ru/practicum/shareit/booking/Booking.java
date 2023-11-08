package ru.practicum.shareit.booking;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * TODO Sprint add-bookings.
 */

@Data
public class Booking {

    //id — уникальный идентификатор бронирования;
    //start — дата и время начала бронирования;
    //end — дата и время конца бронирования;
    //item — вещь, которую пользователь бронирует;
    //booker — пользователь, который осуществляет бронирование;
    //status — статус бронирования. Может принимать одно из следующих значений: WAITING — новое бронирование,
    // ожидает одобрения,
    // APPROVED — бронирование подтверждено владельцем,
    // REJECTED — бронирование отклонено владельцем,
    // CANCELED — бронирование отменено создателем.
    Integer id;
    Integer itemId;
    Integer bookerId;
    LocalDateTime start;
    LocalDateTime end;
    BookingStatus status;
}
