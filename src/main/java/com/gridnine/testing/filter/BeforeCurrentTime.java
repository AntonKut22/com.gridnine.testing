package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class BeforeCurrentTime implements FlightFilter{

    @Override
    public boolean check(Flight flight) {

        List<Segment> segments = flight.getSegments();

        return segments.get(0).getDepartureDate().isAfter(LocalDateTime.now());
    }
}
