package com.ss.utopia.entity;

import java.time.LocalDateTime;
import java.util.Objects;

// Flight entity with data fields
public class Flight {
    private Integer id, reservedSeats;
    private Route route = new Route();
    private Airplane airplane = new Airplane();
    private LocalDateTime departTime;
    private Float seatPrice;

    public Flight() {
    }

    public Flight(Integer id, Integer reservedSeats, Route route, Airplane airplane, LocalDateTime departTime, Float seatPrice) {
        this.id = id;
        this.reservedSeats = reservedSeats;
        this.route = route;
        this.airplane = airplane;
        this.departTime = departTime;
        this.seatPrice = seatPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(Integer reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public LocalDateTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalDateTime departTime) {
        this.departTime = departTime;
    }

    public Float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Float seatPrice) {
        this.seatPrice = seatPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
} // Flight
