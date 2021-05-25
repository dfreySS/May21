package com.ss.utopia.dao;

import com.ss.utopia.entity.Airport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO extends BaseDAO<Airport> {

    public AirportDAO(Connection conn) {
        super(conn);
    }

    public void addAirport(Airport airport) throws SQLException {
        save("INSERT into airport (iata_id, city) values (?, ?)", new Object[] {airport.getAirportCode(), airport.getCity()});
    }

    public void updateAirport(Airport airport) throws SQLException {
        save("UPDATE airport set iata_id = ?, city = ?", new Object[] {airport.getAirportCode(), airport.getCity()});
    }

    public void deleteAirport(Airport airport) throws SQLException, ClassNotFoundException {
        save("DELETE from airport where iata_it = ?", new Object[] {airport.getAirportCode()});
    }

    public List<Airport> readAllAirports() throws SQLException, ClassNotFoundException {
        return read("SELECT * from airport", null);
    }

    @Override
    protected List<Airport> getData(ResultSet results) throws SQLException {
        List<Airport> airports = new ArrayList<>();
        while (results.next()) {
            Airport airport = new Airport(null, null);
            airport.setAirportCode(results.getString("iata_id"));
            airport.setCity(results.getString("city"));
            airports.add(airport);
        }
        return airports;
    }
} // AirportDAO