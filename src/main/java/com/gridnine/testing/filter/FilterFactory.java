package com.gridnine.testing.filter;

public class FilterFactory {

    public FlightFilter createFilter(FilterType filterType) {
        FlightFilter flightFilter = null;
        switch (filterType) {
            case BEFORE_CURRENT_TIME -> flightFilter = new BeforeCurrentTime();
            case ARRIVAL_BEFORE_DEPARTURE -> flightFilter = new ArrivalBeforeDeparture();
            case TRANSFER_MORE_TWO_HOUR -> flightFilter = new TransferMoreTwoHour();
        }
        return flightFilter;
    }
}
