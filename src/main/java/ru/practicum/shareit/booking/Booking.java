package ru.practicum.shareit.booking;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Booking {

    private Integer id;
    private Integer itemId;
    private Integer bookerId;
    private LocalDateTime start;
    private LocalDateTime end;
    private BookingStatus status;
}
