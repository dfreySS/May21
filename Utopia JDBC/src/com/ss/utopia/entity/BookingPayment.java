package com.ss.utopia.entity;

import java.util.Objects;

// BookingPayment entity with data fields
public class BookingPayment {
    private Booking id = new Booking();
    private String stripe;
    private Boolean refunded;

    public BookingPayment() {
    }

    public BookingPayment(Booking id, String stripe, Boolean refunded) {
        this.id = id;
        this.stripe = stripe;
        this.refunded = refunded;
    }

    public Booking getId() {
        return id;
    }

    public void setId(Booking id) {
        this.id = id;
    }

    public String getStripe() {
        return stripe;
    }

    public void setStripe(String stripe) {
        this.stripe = stripe;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingPayment bookingPayment = (BookingPayment) o;
        return Objects.equals(id, bookingPayment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
} // BookingPayment
