package com.ss.utopia.service;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Flight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightService implements CRUDInterface<Flight> {

    @Override
    public static void add(Flight flight) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flightDAO.addFlight(flight);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public static List<Flight> getAll() throws SQLException {

        Connection conn = null;
        List<Flight> flights = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flights = flightDAO.readAllFlights();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return flights;
    }

    @Override
    public static void update(Flight flight) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flightDAO.updateFlight(flight);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public static void delete(Flight flight) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flightDAO.deleteFlight(flight);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}