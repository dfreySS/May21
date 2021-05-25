package com.ss.utopia.service;

import com.ss.utopia.dao.FlightBookingsDAO;
import com.ss.utopia.entity.FlightBookings;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingsService implements CRUDInterface<FlightBookings> {

    @Override
    public void add(FlightBookings flightBooking) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            flightBookingDAO.addFlightBooking(flightBooking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public List<FlightBookings> getAll() throws SQLException {

        Connection conn = null;
        List<FlightBookings> flightBookings = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            flightBookings = flightBookingDAO.readAllFlightBookings();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return flightBookings;
    }

    @Override
    public void update(FlightBookings flightBooking) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            flightBookingDAO.updateFlightBooking(flightBooking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(FlightBookings flightBooking) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            flightBookingDAO.deleteFlightBooking(flightBooking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}