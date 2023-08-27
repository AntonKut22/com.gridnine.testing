package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeforeCurrentTimeTest {

    @Test
    void ifTheDepartureTimeIsEarlierThanTheCurrentTime() {

        LocalDateTime threeDaysFromNow = LocalDateTime.now().minusDays(3);
        Segment segment = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(5));
        Flight flight = new Flight(List.of(segment));
        BeforeCurrentTime beforeCurrentTime = new BeforeCurrentTime();

        assertFalse(beforeCurrentTime.check(flight));
    }

    @Test
    void ifTheDepartureTimeIsLaterThanTheCurrentTime() {

        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        Segment segment = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(5));
        Flight flight = new Flight(List.of(segment));
        BeforeCurrentTime beforeCurrentTime = new BeforeCurrentTime();

        assertTrue(beforeCurrentTime.check(flight));
    }
}
