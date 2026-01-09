package com.flightsearchapi.flightproviderb.model;

import com.flightsearchapi.common.model.BaseFlight;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight extends BaseFlight {

    private String flightNumber;
    private String departure;
    private String arrival;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public Flight(String flightNumber,
                  String departure,
                  String arrival,
                  LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime,
                  BigDecimal price) {

        super();
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
    }
}
