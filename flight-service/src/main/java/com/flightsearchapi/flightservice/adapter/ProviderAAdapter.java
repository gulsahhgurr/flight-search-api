package com.flightsearchapi.flightservice.adapter;

import com.flightsearchapi.flightcommon.converter.DateConverter;
import com.flightsearchapi.flightservice.model.FlightSearchRequest;
import com.flightsearchapi.flightservice.model.FlightSearchResponse;
import com.flightsearchapi.flightservice.provider.FlightProvider;

import com.flightsearchapi.flightservice.providera.FlightPortAService;
import com.flightsearchapi.flightservice.providera.FlightPortA;
import com.flightsearchapi.flightservice.providera.SearchRequest;
import com.flightsearchapi.flightservice.providera.SearchResponse;
import com.flightsearchapi.flightservice.providera.Flight;

import com.flightsearchapi.flightservice.service.LoggingService;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Adapter Pattern: Provider A SOAP yapısını ortak modele dönüştürür.
 */
@Component
public class ProviderAAdapter implements FlightProvider {

    private final LoggingService loggingService;

    public ProviderAAdapter(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public List<FlightSearchResponse> search(FlightSearchRequest request) {

        List<FlightSearchResponse> flights = new ArrayList<>();
        FlightPortAService service = new FlightPortAService();
        FlightPortA port = service.getFlightPortASoap11();
        SearchRequest soapRequest = new SearchRequest();
        SearchResponse soapResponse = new SearchResponse();

        try {
            soapRequest.setOrigin(request.getDestination());
            soapRequest.setDestination(request.getDestination());
            soapRequest.setDepartureDate(DateConverter.toXMLGregorianCalendar(request.getDepartureDate()));
            soapResponse = port.search(soapRequest);

            if (!soapResponse.isHasError()) {
                for (Flight flight : soapResponse.getFlightAOptions()) {
                    FlightSearchResponse response = new FlightSearchResponse();
                    response.setFlightNo(flight.getFlightNo());
                    response.setOrigin(flight.getOrigin());
                    response.setDestination(flight.getDestination());
                    response.setDepartureTime(flight.getDeparturedatetime().toString());
                    response.setArrivalTime(flight.getArrivaldatetime().toString());
                    response.setPrice(flight.getPrice());
                    flights.add(response);
                }
            }
            return flights;

        } catch (Exception e) {
            System.err.println("Provider A error: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            loggingService.log(getProviderName(), soapRequest, soapResponse);
        }
    }

    @Override
    public String getProviderName() {
        return "Provider-A";
    }
}