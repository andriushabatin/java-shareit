package ru.practicum.shareit.booking;

import java.time.LocalDateTime;

public class BookingDto {

    private Integer id;
    private Integer itemId;
    private Integer bookerId;
    private LocalDateTime start;
    private LocalDateTime end;
    private BookingStatus status;
}
