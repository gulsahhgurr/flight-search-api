package com.flightsearchapi.flightproviderb.model;

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
