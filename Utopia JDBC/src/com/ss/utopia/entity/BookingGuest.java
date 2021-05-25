package com.ss.utopia.entity;

import java.awt.print.Book;
import java.util.Objects;

// BookingGuest entity with data fields
public class BookingGuest {
    private Booking booking = new Booking();
    private String email, phone;

    public BookingGuest() {
    }

    public BookingGuest(Booking booking, String email, String phone) {
        this.booking = booking;
        this.email = email;
        this.phone = phone;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingGuest bookingGuest = (BookingGuest) o;
        return Objects.equals(booking, bookingGuest.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booking);
    }
} // BookingGuest
