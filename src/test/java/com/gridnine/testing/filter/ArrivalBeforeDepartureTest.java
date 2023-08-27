package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalBeforeDepartureTest {

    @Test
    void ifTheArrivalDateIsEarlierThanTheDepartureDate() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().minusDays(3);
        Segment segment = new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(5));
        Flight flight = new Flight(List.of(segment));
        ArrivalBeforeDeparture arrivalBeforeDeparture = new ArrivalBeforeDeparture();

        assertFalse(arrivalBeforeDeparture.check(flight));
    }

    @Test
    void ifTheArrivalDateIsLaterThanTheDepartureDate() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().minusDays(3);
        Segment segment = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(5));
        Flight flight = new Flight(List.of(segment));
        ArrivalBeforeDeparture arrivalBeforeDeparture = new ArrivalBeforeDeparture();

        assertTrue(arrivalBeforeDeparture.check(flight));
    }
}
