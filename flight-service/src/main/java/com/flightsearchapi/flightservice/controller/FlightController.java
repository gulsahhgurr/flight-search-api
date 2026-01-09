package com.flightsearchapi.flightservice.controller;

import com.flightsearchapi.flightservice.model.FlightSearchRequest;
import com.flightsearchapi.flightservice.model.FlightSearchResponse;
import com.flightsearchapi.flightservice.service.FlightSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightSearchService flightSearchService;

    public FlightController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightSearchResponse>> searchFlights(@RequestBody FlightSearchRequest request) {
        List<FlightSearchResponse> flights = flightSearchService.search(request);
        return ResponseEntity.ok(flights);
    }
    @GetMapping("/search-chepast")
    public ResponseEntity<List<FlightSearchResponse>> searchChepastFlights(@RequestBody FlightSearchRequest request) {
        List<FlightSearchResponse> flights = flightSearchService.searchCheapest(request);
        return ResponseEntity.ok(flights);
    }
}