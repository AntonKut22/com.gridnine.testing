package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightFilters {

    private static final List<FlightFilter> FILTERS = new ArrayList<>();

    public static void add(FlightFilter flightFilter) {
        FILTERS.add(flightFilter);
    }

    public static void delete(FlightFilter flightFilter) {
        FILTERS.remove(flightFilter);
    }

    public static void clear() {
        FILTERS.clear();
    }

    public static boolean check(Flight flight) {

        for (FlightFilter filter : FILTERS) {
            if (!filter.check(flight)) {
                return false;
            }
        }
        return true;
    }
}
