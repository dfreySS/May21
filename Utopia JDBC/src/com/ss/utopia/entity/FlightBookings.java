package com.ss.utopia.entity;

import java.util.Objects;

// FlightBookings entity with data fields
public class FlightBookings {
    private Flight flight = new Flight();
    private Booking booking = new Booking();

    public FlightBookings() {
    }

    public FlightBookings(Flight flight, Booking booking) {
        this.flight = flight;
        this.booking = booking;
    }

    public Flight getId() {
        return flight;
    }

    public void setId(Flight id) {
        this.flight = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBookings flightBookings = (FlightBookings) o;
        return Objects.equals(flight, flightBookings.flight) && Objects.equals(booking, flightBookings.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight);
    }
} // FlightBookings
