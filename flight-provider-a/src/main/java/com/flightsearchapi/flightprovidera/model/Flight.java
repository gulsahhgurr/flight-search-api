package com.flightsearchapi.flightprovidera.model;

import com.flightsearchapi.common.model.BaseFlight;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight extends BaseFlight {
    private String flightNo;
    private String origin;
    private String destination;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Flight(String flightNo, String origin, String destination, LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime, BigDecimal price) {
        super();
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;

    }
}
