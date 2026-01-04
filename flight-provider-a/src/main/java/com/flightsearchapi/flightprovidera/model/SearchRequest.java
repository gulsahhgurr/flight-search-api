package com.flightsearchapi.flightprovidera.model;

import com.flightsearchapi.common.model.BaseSearchRequest;

public class SearchRequest extends BaseSearchRequest {

    private String origin = "";
    private String destination = "";
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
