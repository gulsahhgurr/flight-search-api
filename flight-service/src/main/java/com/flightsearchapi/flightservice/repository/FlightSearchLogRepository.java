package com.flightsearchapi.flightservice.repository;

import com.flightsearchapi.flightservice.entity.FlightSearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchLogRepository extends JpaRepository<FlightSearchLog, Long> {
}