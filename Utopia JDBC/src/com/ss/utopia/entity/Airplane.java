package com.ss.utopia.entity;

import java.util.Objects;

// Airplane entity with data fields
public class Airplane {
    private Integer id;
    private AirplaneType type = new AirplaneType();

    public Airplane() {
    }

    public Airplane(Integer id, AirplaneType type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(id, airplane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
} // Airplane
