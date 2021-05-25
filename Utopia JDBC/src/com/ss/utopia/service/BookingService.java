package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.entity.Booking;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingService implements CRUDInterface<Booking> {

    @Override
    public void add(Booking booking) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookingDAO.addBooking(booking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public List<Booking> getAll() throws SQLException {
        Connection conn = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookings = bookingDAO.readAllBookings();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }
        return bookings;
    }

    @Override
    public void update(Booking booking) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookingDAO.updateBooking(booking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(Booking booking) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookingDAO.updateBooking(booking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}