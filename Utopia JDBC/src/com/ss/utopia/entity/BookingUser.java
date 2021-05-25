package com.ss.utopia.entity;

import java.util.Objects;

// BookingUser entity with data fields
public class BookingUser {
    private Booking booking = new Booking();
    private User user = new User();

    public BookingUser() {
    }

    public BookingUser(Booking booking, User user) {
        this.booking = booking;
        this.user = user;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingUser bookingUser = (BookingUser) o;
        return Objects.equals(booking, bookingUser.booking) && Objects.equals(user, bookingUser.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
} // BookingUser
