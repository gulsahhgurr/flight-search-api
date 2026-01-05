package com.flightsearchapi.flightproviderb.service;

import com.flightsearchapi.flightcommon.converter.DateConverter;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import com.flightsearchapi.flightproviderb.generated.AvailabilitySearchRequest;
import com.flightsearchapi.flightproviderb.generated.AvailabilitySearchResponse;
import com.flightsearchapi.flightproviderb.generated.Flight;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Endpoint
public class FlightService {

    private static final String NAMESPACE_URI = "http://example.com/flightproviderb";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "availabilitySearchRequest")
    @ResponsePayload
    public AvailabilitySearchResponse searchFlights(@RequestPayload AvailabilitySearchRequest request) {
        AvailabilitySearchResponse response = new AvailabilitySearchResponse();

        Flight flight = new Flight();
        flight.setFlightNumber("TK-101");
        flight.setArrival(request.getArrival());
        flight.setDeparture(request.getDeparture());
        flight.setDeparturedatetime(DateConverter.toXMLGregorianCalendar(LocalDateTime.now().plusDays(1)));
        flight.setArrivaldatetime(DateConverter.toXMLGregorianCalendar(LocalDateTime.now().plusDays(1).plusHours(3)));
        flight.setPrice(new BigDecimal("299.99"));

        response.getFlightOptions().add(flight);

        return response;
    }
}