package com.flightsearchapi.common.model;

import java.time.LocalDateTime;

public class BaseSearchRequest {

    private LocalDateTime departureDate;

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

}
