package com.flightsearchapi.common.model;

import java.time.LocalDateTime;

public class BaseSearchRequest {

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    private LocalDateTime departureDate;

    /*b*/
    private String departure = "";
    private String arrival = "";


}
