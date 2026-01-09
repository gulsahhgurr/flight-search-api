package com.flightsearchapi.flightservice.provider;

import com.flightsearchapi.flightservice.model.FlightSearchRequest;
import com.flightsearchapi.flightservice.model.FlightSearchResponse;

import java.util.List;

public interface FlightProvider {
    
    /**
     * Uçuş araması yapar
     */
    List<FlightSearchResponse> search(FlightSearchRequest request);
    
    /**
     * Provider adını döner
     */
    String getProviderName();
}