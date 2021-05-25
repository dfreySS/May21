package com.ss.utopia.entity;

import sun.management.Agent;

import java.util.Objects;

// BookingAgent entity with data fields
public class BookingAgent {
    private Booking booking = new Booking();
    private User agent = new User();

    public BookingAgent() {
    }

    public BookingAgent(Booking booking, User agent) {
        this.booking = booking;
        this.agent = agent;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingAgent bookingAgent = (BookingAgent) o;
        return Objects.equals(booking, bookingAgent.booking) && Objects.equals(agent, bookingAgent.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booking, agent);
    }
} // BookingAgent
