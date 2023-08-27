package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.Duration;
import java.util.List;

public class TransferMoreTwoHour implements FlightFilter {

    @Override
    public boolean check(Flight flight) {

        List<Segment> segments = flight.getSegments();
        Duration duration = Duration.ZERO;
        int maxTransferMinutes = 120;

        for (int i = 1; i < segments.size(); i++) {
            duration = duration.plus(Duration.between(segments.get(i - 1).getArrivalDate(),
                    segments.get(i).getDepartureDate()));

            if (duration.toMinutes() > maxTransferMinutes) {
                return false;
            }
        }
        return true;
    }
}
