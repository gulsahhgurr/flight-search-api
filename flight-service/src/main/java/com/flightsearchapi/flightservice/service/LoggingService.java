package com.flightsearchapi.flightservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightsearchapi.flightservice.entity.FlightSearchLog;
import com.flightsearchapi.flightservice.repository.FlightSearchLogRepository;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final FlightSearchLogRepository logRepository;
    private final ObjectMapper objectMapper;

    public LoggingService(FlightSearchLogRepository logRepository) {
        this.logRepository = logRepository;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Provider SOAP request/response loglar
     */
    public void log(String providerName, Object request, Object response) {
        try {
            FlightSearchLog log = new FlightSearchLog();
            log.setEndpoint(providerName);
            log.setRequestBody(toJson(request));
            log.setResponseBody(toJson(response));

            logRepository.save(log);
        } catch (Exception e) {
            System.err.println("❌ Logging error: " + e.getMessage());
        }
    }

    private String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            return obj != null ? obj.toString() : "null";
        }
    }
}