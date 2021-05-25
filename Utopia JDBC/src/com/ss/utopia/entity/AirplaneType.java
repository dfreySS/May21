package com.ss.utopia.entity;

import java.util.Objects;

// AirplaneTpe entity with data fields
public class AirplaneType {
    private Integer id, maxCapacity;

    public AirplaneType() {
    }

    public AirplaneType(Integer id, Integer maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneType airplaneType = (AirplaneType) o;
        return Objects.equals(id, airplaneType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
} // AirplaneType
