package com.ss.utopia.service;


import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.entity.Airport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Service to commit changes only if they all succeed, otherwise rollback server
public class AirportService implements CRUDInterface<Airport> {

    @Override
    public static List<Airport> getAll() throws SQLException {
        Connection conn = null;
        List<Airport> airports = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            AirportDAO airportDAO = new AirportDAO(conn);
            airports = airportDAO.readAllAirports();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return airports;
    }

    @Override
    public static void add(Airport airport) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            AirportDAO airportDAO = new AirportDAO(conn);
            airportDAO.addAirport(airport);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public static void update(Airport airport) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            AirportDAO airportDAO = new AirportDAO(conn);
            airportDAO.updateAirport(airport);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public static void delete(Airport airport) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            AirportDAO airportDAO = new AirportDAO(conn);
            airportDAO.deleteAirport(airport);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}