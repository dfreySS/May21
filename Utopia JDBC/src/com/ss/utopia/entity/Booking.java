package com.ss.utopia.entity;

import java.util.Objects;

// Booking entity with data fields
public class Booking {
    private Integer id;
    private Boolean isActive;
    private String confirmCode;

    public Booking() {
    }

    public Booking(Integer id, Boolean isActive, String confirmCode) {
        this.id = id;
        this.isActive = isActive;
        this.confirmCode = confirmCode;
    }

    public Booking(Boolean isActive, String confirmCode) {
        this.isActive = isActive;
        this.confirmCode = confirmCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
} // Booking
