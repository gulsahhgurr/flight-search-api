package com.flightsearchapi.flightprovidera.model;

import com.flightsearchapi.common.model.BaseSearchResult;

import java.util.List;

public class SearchResult extends BaseSearchResult<Flight> {

    public SearchResult() {
        super();
    }

    public SearchResult(boolean hasError, List<Flight> flightOptions, String errorMessage) {
        super(hasError, flightOptions, errorMessage);
    }
}
