package com.flightsearchapi.common.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BaseFlight {

    private LocalDateTime departuredatetime;

    public LocalDateTime getArrivaldatetime() {
        return arrivaldatetime;
    }

    public void setArrivaldatetime(LocalDateTime arrivaldatetime) {
        this.arrivaldatetime = arrivaldatetime;
    }

    public LocalDateTime getDeparturedatetime() {
        return departuredatetime;
    }

    public void setDeparturedatetime(LocalDateTime departuredatetime) {
        this.departuredatetime = departuredatetime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private LocalDateTime arrivaldatetime;
    private BigDecimal price;


/*bb
private String flightNumber;
    private String departure;
    private String arrival;*/

}