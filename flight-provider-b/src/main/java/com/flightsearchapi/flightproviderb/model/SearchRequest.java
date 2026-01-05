package com.flightsearchapi.flightproviderb.model;

import com.flightsearchapi.common.model.BaseSearchRequest;

public class SearchRequest extends BaseSearchRequest {

    private String departure = "";
    private String arrival = "";

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

}
