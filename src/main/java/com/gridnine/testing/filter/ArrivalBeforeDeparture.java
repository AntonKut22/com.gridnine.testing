package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.util.List;

public class ArrivalBeforeDeparture implements FlightFilter {

    @Override
    public boolean check(Flight flight) {

        List<Segment> segments = flight.getSegments();

        for (Segment segment : segments) {
            if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                return false;
            }
        }
        return true;
    }
}
