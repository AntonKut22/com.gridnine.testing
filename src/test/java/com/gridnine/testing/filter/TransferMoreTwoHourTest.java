package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferMoreTwoHourTest {

    @Test
    void ifTheTransferTimeIsMoreThanTwoHours() {

        LocalDateTime threeDaysFromNow = LocalDateTime.now().minusDays(3);
        Segment segment1 = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(5));
        Segment segment2 = new Segment(threeDaysFromNow.plusHours(10), threeDaysFromNow.plusHours(15));
        Flight flight = new Flight(List.of(segment1, segment2));
        TransferMoreTwoHour transferMoreTwoHour = new TransferMoreTwoHour();

        assertFalse(transferMoreTwoHour.check(flight));
    }

    @Test
    void ifTheTransferTimeIsLessThanTwoHours() {

        LocalDateTime threeDaysFromNow = LocalDateTime.now().minusDays(3);
        Segment segment1 = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(5));
        Segment segment2 = new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(15));
        Flight flight = new Flight(List.of(segment1, segment2));
        TransferMoreTwoHour transferMoreTwoHour = new TransferMoreTwoHour();

        assertTrue(transferMoreTwoHour.check(flight));
    }
}
