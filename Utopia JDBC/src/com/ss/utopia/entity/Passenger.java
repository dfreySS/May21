package com.ss.utopia.entity;

import java.time.LocalDate;
import java.util.Objects;

// Passenger entity with data fields
public class Passenger {
    private Integer id;
    private Booking booking = new Booking();
    private String givenName, familyName, gender, address;
    private LocalDate dob;

    public Passenger() {
    }

    public Passenger(Integer id, Booking booking, String givenName, String familyName, String gender, String address, LocalDate dob) {
        this.id = id;
        this.booking = booking;
        this.givenName = givenName;
        this.familyName = familyName;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
} // Passenger
