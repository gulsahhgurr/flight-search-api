package com.flightsearchapi.flightservice.model;

import java.time.LocalDateTime;

public class FlightSearchRequest {
    private String origin;
    private String destination;
    private LocalDateTime departureDate;

    // Getters and Setters
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDateTime getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDateTime departureDate) { this.departureDate =departureDate; }
}