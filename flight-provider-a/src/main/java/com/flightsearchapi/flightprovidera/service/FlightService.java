package com.flightsearchapi.flightprovidera.service;

import com.flightsearchapi.flightprovidera.generated.AvailabilitySearchRequest;
import com.flightsearchapi.flightprovidera.generated.AvailabilitySearchResponse;
import com.flightsearchapi.flightprovidera.generated.Flight;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
public class FlightService {

    private static final String NAMESPACE_URI = "http://example.com/flightprovidera";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "availabilitySearchRequest")
    @ResponsePayload
    public AvailabilitySearchResponse searchFlights(@RequestPayload AvailabilitySearchRequest request) {
        
        AvailabilitySearchResponse response = new AvailabilitySearchResponse();
        response.setHasError(false);

        Flight flight = new Flight();
        flight.setFlightNumber("TK-101");
        flight.setAirline("Turkish Airlines");
        flight.setDepartureAirport(request.getOrigin());
        flight.setArrivalAirport(request.getDestination());
        flight.setPrice(new BigDecimal("299.99"));
        flight.setCurrency("USD");
        flight.setAvailableSeats(50);
        flight.setProvider("Provider-A");
        flight.setCabinClass("Economy");
        flight.setRefundable(true);
        flight.setLoyaltyPoints(500);

        response.getFlightOptions().add(flight);

        return response;
    }
}