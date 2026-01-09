package com.flightsearchapi.flightservice.adapter;


import com.flightsearchapi.flightcommon.converter.DateConverter;
import com.flightsearchapi.flightservice.model.FlightSearchRequest;
import com.flightsearchapi.flightservice.model.FlightSearchResponse;
import com.flightsearchapi.flightservice.provider.FlightProvider;
import com.flightsearchapi.flightservice.providerb.Flight;
import com.flightsearchapi.flightservice.providerb.SearchRequest;
import com.flightsearchapi.flightservice.providerb.SearchResponse;
import com.flightsearchapi.flightservice.providerb.FlightPortBService;
import com.flightsearchapi.flightservice.service.LoggingService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.flightsearchapi.flightcommon.converter.DateConverter.toXMLGregorianCalendar;


@Component
public class ProviderBAdapter implements FlightProvider {
    private final LoggingService loggingService;

    public ProviderBAdapter(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public List<FlightSearchResponse> search(FlightSearchRequest request) {

        List<FlightSearchResponse> flights = new ArrayList<>();

        FlightPortBService service = new FlightPortBService();
        var port = service.getFlightPortBSoap11();
        SearchRequest soapRequest = new SearchRequest();
        SearchResponse soapResponse = new SearchResponse();
        try {

            soapRequest.setDeparture(request.getOrigin());
            soapRequest.setArrival(request.getOrigin());
            soapRequest.setDepartureDate(DateConverter.toXMLGregorianCalendar(request.getDepartureDate()));

            soapResponse = port.search(soapRequest);

            if (!soapResponse.isHasError()) {
                for (Flight flight : soapResponse.getFlightBOptions()) {
                    FlightSearchResponse response = new FlightSearchResponse();
                    response.setFlightNumber(flight.getFlightNumber());
                    response.setDeparture(flight.getDeparture());
                    response.setArrival(flight.getArrival());
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
        return "Provider-B";
    }
}
