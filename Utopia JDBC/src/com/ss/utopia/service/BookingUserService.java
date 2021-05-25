package com.ss.utopia.service;

import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.entity.BookingUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingUserService implements CRUDInterface<BookingUser> {
    @Override
    public void add(BookingUser bookingUser) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            bookingUserDAO.addBookingUser(bookingUser);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public List<BookingUser> getAll() throws SQLException {

        Connection conn = null;
        List<BookingUser> bookingUsers = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            bookingUserDAO.readAllBookingUsers();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return bookingUsers;
    }

    @Override
    public void update(BookingUser bookingUser) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            bookingUserDAO.updateBookingUser(bookingUser);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(BookingUser bookingUser) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            bookingUserDAO.deleteBookingUser(bookingUser);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}