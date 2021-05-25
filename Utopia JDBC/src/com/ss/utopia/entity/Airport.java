package com.ss.utopia.entity;

import java.util.Objects;

// Airport entity with data fields
public class Airport {
    private String airportCode; // short code for airport
    private String city; // name of airport

    public Airport () {

    }

    public Airport(String airportCode, String city) {
        this.airportCode = airportCode;
        this.city = city;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportCode, airport.airportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportCode);
    }
} // Airport
