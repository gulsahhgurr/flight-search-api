package com.flightsearchapi.common.model;

import java.util.ArrayList;
import java.util.List;

public class BaseSearchResult <T extends BaseFlight> {

    private boolean hasError = false;
    private List<T> flightOptions = new ArrayList<>();
    private String errorMessage;

    // Constructors
    public BaseSearchResult() {
    }

    public BaseSearchResult(boolean hasError, List<T> flightOptions, String errorMessage) {
        this.hasError = hasError;
        this.flightOptions = flightOptions;
        this.errorMessage = errorMessage;
    }

    // Getters and Setters
    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public List<T> getFlightOptions() {
        return flightOptions;
    }

    public void setFlightOptions(List<T> flightOptions) {
        this.flightOptions = flightOptions;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}