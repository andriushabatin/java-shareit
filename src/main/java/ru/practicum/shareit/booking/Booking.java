package ru.practicum.shareit.booking;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * TODO Sprint add-bookings.
 */

@Data
public class Booking {

    Integer id;
    Integer itemId;
    Integer bookerId;
    LocalDateTime start;
    LocalDateTime end;
    BookingStatus status;
}
