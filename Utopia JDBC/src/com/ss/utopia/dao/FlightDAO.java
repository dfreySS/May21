package com.ss.utopia.dao;

import com.ss.utopia.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends BaseDAO<Flight> {

    public FlightDAO(Connection conn) {
        super(conn);
    }

    public void addFlight (Flight flight) throws SQLException {
        save("INSERT into flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) values (?, ?, ?, ?, ?)",
                new Object[] {flight.getRoute().getId(), flight.getAirplane().getId(), Timestamp.valueOf(flight.getDepartTime()),
                        flight.getReservedSeats(), flight.getSeatPrice()});
    }

    public void updateFlight (Flight flight) throws SQLException {
        save("UPDATE flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ?",
                new Object[] {flight.getRoute().getId(), flight.getAirplane().getId(), Timestamp.valueOf(flight.getDepartTime()),
                        flight.getReservedSeats(), flight.getSeatPrice()});
    }

    public void deleteFlight (Flight flight) throws SQLException {
        save("DELETE from flight where id = ?",
                new Object[] {flight.getId()});
    }

    public List<Flight> readAllFlights() throws SQLException, ClassNotFoundException {
        return read("select * from flight inner join " +
                "airplane_type on flight.airplane_id = airplane_type.id inner join " +
                "route on flight.route_id = route.id", null);
    }

    public List<Flight> readFlightsByRoute(Route route) throws SQLException, ClassNotFoundException {
        return read("SELECT * from flight where route_id = ?",
                new Object[] {route.getId()});
    }

    public Flight readFlightByID(Integer id) throws SQLException, ClassNotFoundException {
        List<Flight> flights = read("SELECT * from flight where id = ?",  new Object[] {id});
        return flights.get(0);
    }

    @Override
    protected List<Flight> getData(ResultSet results) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        while (results.next()) {
            Flight flight = new Flight();
            flight.setId(results.getInt("id"));
            flight.getRoute().setId(results.getInt("route_id"));
            flight.getAirplane().setId(results.getInt("airplane_id"));
            flight.setDepartTime(((results.getTimestamp("departure_time").toLocalDateTime())));
            flight.setReservedSeats(results.getInt("reserved_seats"));
            flight.setSeatPrice(results.getFloat("seat_price"));
            // need to populate route, airplane type
            flight.getAirplane().getType().setId(results.getInt("id"));
            flight.getAirplane().getType().setMaxCapacity(results.getInt("max_capacity"));

//            flight.getRoute().setOrigin(results.getString("origin_id"));
//            flight.getRoute().setDestination(results.getString("destination_id"));

            flights.add(flight);
        }
        return flights;
    }
}