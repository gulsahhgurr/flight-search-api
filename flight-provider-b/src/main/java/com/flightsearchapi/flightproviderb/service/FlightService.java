package com.flightsearchapi.flightproviderb.service;

import com.flightsearchapi.flightcommon.converter.DateConverter;
import com.flightsearchapi.flightproviderb.generated.SearchRequest;
import com.flightsearchapi.flightproviderb.generated.SearchResponse;
import com.flightsearchapi.flightproviderb.generated.Flight;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Endpoint
public class FlightService {

    private static final String NAMESPACE_URI = "http://example.com/flightproviderb";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SearchRequest")
    @ResponsePayload
    public SearchResponse searchFlights(@RequestPayload SearchRequest request) {
        SearchResponse response = new SearchResponse();

        // Add basic validation
        if (request == null ||
                request.getDeparture() == null || request.getDeparture().trim().isEmpty() ||
                request.getArrival() == null || request.getArrival().trim().isEmpty() ||
                request.getDepartureDate() == null) {

            response.setHasError(true);
            response.setErrorMessage("Invalid search parameters. Origin, destination, and departure date are required.");
            return response;
        }

        // Validate departure date is not in the past
        if (DateConverter.toLocalDateTime(request.getDepartureDate()).isBefore(LocalDateTime.now())) {
            response.setHasError(true);
            response.setErrorMessage("Departure date cannot be in the past.");
            return response;
        }

        try {
            Random random = new Random();
            List<Flight> flightOptions = new ArrayList<>();

            // Generate 3 flight options with realistic times
            for (int i = 1; i <= 3; i++) {
                LocalDateTime departureTime = DateConverter.toLocalDateTime(request.getDepartureDate())
                        .withHour(6 + (i * 3)) // Flights at 6am, 9am, 12pm
                        .withMinute(0)
                        .withSecond(0);

                Duration flightDuration = Duration.ofMinutes(
                        120 + (long) (random.nextDouble() * 180)); // 2-5 hour flights

                LocalDateTime arrivalTime = departureTime.plus(flightDuration);

                BigDecimal basePrice = BigDecimal.valueOf(100.0);
                BigDecimal multiplier = BigDecimal.valueOf(i * 50);
                BigDecimal randomPrice = BigDecimal.valueOf(random.nextInt(100));
                BigDecimal totalPrice = basePrice.add(multiplier).add(randomPrice);

                Flight flightOption = new Flight();
                flightOption.setFlightNumber("TK" + (1000 + i));
                flightOption.setDeparture("IST");
                flightOption.setArrival("COV");
                flightOption.setDeparturedatetime(DateConverter.toXMLGregorianCalendar(departureTime));
                flightOption.setArrivaldatetime(DateConverter.toXMLGregorianCalendar(arrivalTime));
                flightOption.setPrice(totalPrice);

                Flight flightOption2 = new Flight();
                flightOption2.setFlightNumber("PC" + (1000 + i));
                flightOption2.setDeparture("IST");
                flightOption2.setArrival("COV");
                flightOption2.setDeparturedatetime(DateConverter.toXMLGregorianCalendar(departureTime));
                flightOption2.setArrivaldatetime(DateConverter.toXMLGregorianCalendar(arrivalTime));
                flightOption2.setPrice(totalPrice);

                Flight flightOption3 = new Flight();
                flightOption3.setFlightNumber("XQ" + (1000 + i));
                flightOption3.setDeparture("IST");
                flightOption3.setArrival("COV");
                flightOption3.setDeparturedatetime(DateConverter.toXMLGregorianCalendar(departureTime));
                flightOption3.setArrivaldatetime(DateConverter.toXMLGregorianCalendar(arrivalTime));
                flightOption3.setPrice(totalPrice);
                flightOptions.add(flightOption);
                flightOptions.add(flightOption2);
                flightOptions.add(flightOption3);
            }
            response.setHasError(false);
            response.getFlightBOptions().addAll(flightOptions);
            response.setErrorMessage(null);
            return response;

        } catch (Exception e) {
            // Log the exception in a real application
            response.setHasError(true);
            response.setErrorMessage("An error occurred while searching for flights: " + e.getMessage());
            return response;
        }
    }
}