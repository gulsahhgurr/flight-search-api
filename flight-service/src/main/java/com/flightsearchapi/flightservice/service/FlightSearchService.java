package com.flightsearchapi.flightservice.service;

import com.flightsearchapi.flightservice.model.FlightSearchRequest;
import com.flightsearchapi.flightservice.model.FlightSearchResponse;
import com.flightsearchapi.flightservice.provider.FlightProvider;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightSearchService {

    private final List<FlightProvider> providers;

    public FlightSearchService(List<FlightProvider> providers) {
        this.providers = providers;
    }

    public List<FlightSearchResponse> search(FlightSearchRequest request) {
        return providers.stream()
                .flatMap(provider -> {
                    try {
                        return provider.search(request).stream();
                    } catch (Exception e) {
                        System.err.println(provider.getProviderName() + " error: " + e.getMessage());
                        return java.util.stream.Stream.empty();
                    }
                })
                .collect(Collectors.toList());
    }
    public List<FlightSearchResponse> searchCheapest(FlightSearchRequest request) {
        List<FlightSearchResponse> allFlights = search(request);

        // 2. Grupla ve her gruptan en ucuzunu seç
        return allFlights.stream()
                .collect(Collectors.groupingBy(
                        this::createGroupKey,
                        Collectors.minBy(Comparator.comparing(FlightSearchResponse::getPrice))
                ))
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted(Comparator.comparing(FlightSearchResponse::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Gruplama anahtarı oluşturur
     */
    private String createGroupKey(FlightSearchResponse flight) {
        return String.join("|",
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime()
        );
    }
}