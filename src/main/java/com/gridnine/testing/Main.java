package com.gridnine.testing;


import com.gridnine.testing.filter.*;
import com.gridnine.testing.flight.FlightBuilder;
import com.gridnine.testing.flight.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        FilterFactory filterFactory = new FilterFactory();

        FlightFilter beforeCurrentTime = filterFactory.createFilter(FilterType.BEFORE_CURRENT_TIME);
        FlightFilter arrivalBeforeDeparture = filterFactory.createFilter(FilterType.ARRIVAL_BEFORE_DEPARTURE);
        FlightFilter transferMoreTwoHour = filterFactory.createFilter(FilterType.TRANSFER_MORE_TWO_HOUR);

        FlightFilters.add(beforeCurrentTime);
        System.out.println("using a filter \"beforeCurrentTime\" ");
        printFlights(flights);
        FlightFilters.clear();

        FlightFilters.add(arrivalBeforeDeparture);
        System.out.println("using a filter \"arrivalBeforeDeparture\" ");
        printFlights(flights);
        FlightFilters.clear();

        FlightFilters.add(transferMoreTwoHour);
        System.out.println("using a filter \"transferMoreTwoHour\" ");
        printFlights(flights);

        FlightFilters.add(beforeCurrentTime);
        FlightFilters.add(arrivalBeforeDeparture);
        System.out.println("using all filter");
        printFlights(flights);

        FlightFilters.clear();
        System.out.println("without filters");
        printFlights(flights);

    }

    public static void printFlights(List<Flight> flights) {
        flights.stream().filter(FlightFilters::check).forEach(flight -> System.out.println(flight.toString()));
    }
}