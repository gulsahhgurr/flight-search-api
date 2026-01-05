package com.flightsearchapi.flightprovidera.service;

import com.flightsearchapi.flightcommon.converter.DateConverter;
import com.flightsearchapi.flightprovidera.generated.AvailabilitySearchRequest;
import com.flightsearchapi.flightprovidera.generated.AvailabilitySearchResponse;
import com.flightsearchapi.flightprovidera.generated.Flight;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Endpoint
public class FlightService {

    private static final String NAMESPACE_URI = "http://example.com/flightprovidera";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "availabilitySearchRequest")
    @ResponsePayload
    public AvailabilitySearchResponse searchFlights(@RequestPayload AvailabilitySearchRequest request) {
        AvailabilitySearchResponse response = new AvailabilitySearchResponse();

        Flight flight = new Flight();
        flight.setFlightNo("TK-101");
        flight.setOrigin(request.getOrigin());
        flight.setDestination(request.getDestination());
        flight.setDeparturedatetime(DateConverter.toXMLGregorianCalendar(LocalDateTime.now().plusDays(1)));
        flight.setArrivaldatetime(DateConverter.toXMLGregorianCalendar(LocalDateTime.now().plusDays(1).plusHours(3)));
        flight.setPrice(new BigDecimal("299.99"));

        response.getFlightOptions().add(flight);

        return response;
    }
}