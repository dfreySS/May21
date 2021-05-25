package com.ss.utopia.service;


import com.ss.utopia.dao.*;
import com.ss.utopia.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ServiceUtils {
    public static Flight getFlight(Integer id) throws SQLException {
        Connection conn = null;
        Flight flight = new Flight();

        try {
            conn = ConnectionService.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flight = flightDAO.readFlightByID(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return flight;
    }

    public static List<Booking> getBookingsByUser(User user) throws SQLException {

        Connection conn = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            conn = ConnectionService.getConnection();
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            BookingDAO bookingDAO = new BookingDAO(conn);
            List<BookingUser> bookingUsers = bookingUserDAO.readBookingsByUser(user);
            for (BookingUser bookingUser : bookingUsers) {
                bookings.add(bookingDAO.readBookingByID(bookingUser.getBooking().getId()));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return bookings;
    }

    public static BookingUser getBookingUserByBooking(Booking booking) throws SQLException {

        Connection conn = null;
        BookingUser bookingUser = new BookingUser();

        try {
            conn = ConnectionService.getConnection();
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            bookingUser = bookingUserDAO.readBookingUserByBooking(booking);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return bookingUser;
    }

    public static FlightBookings getFlightBookingByBooking(Booking booking) throws SQLException {

        Connection conn = null;
        FlightBookings flightBookings = new FlightBookings();

        try {
            conn = ConnectionService.getConnection();
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            flightBookings = flightBookingDAO.getFlightBookingByBooking(booking);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return flightBookings;
    }

    public static List<Flight> getFlightsByUser(User user) throws SQLException {

        Connection conn = null;
        List<Flight> flights = new ArrayList<>();
        try {
            conn = ConnectionService.getConnection();
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            FlightDAO flightDAO = new FlightDAO(conn);
            List<Booking> bookings = getBookingsByUser(user);
            List<FlightBookings> flightBookings = new ArrayList<>();

            for (Booking booking : bookings) {
                flightBookings.add(flightBookingDAO.getFlightBookingByBooking(booking));
            }
            for (FlightBookings flightBooking : flightBookings) {
                flights.add(flightDAO.readFlightByID(flightBooking.getId().getId()));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return flights;
    }

    public static void cancelBooking(Booking booking) throws SQLException {

        Connection conn = null;
        booking.setActive(false);
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookingDAO.updateBooking(booking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public static User getUserByID(Integer id) throws SQLException {

        User user = new User();
        Connection conn = null;

        try {
            conn = ConnectionService.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            user = userDAO.readUserById(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }

        return user;
    }

    public static Booking getBookingByID(Integer id) throws SQLException {

        Connection conn = null;
        Booking booking = new Booking();

        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            booking = bookingDAO.readBookingByID(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return booking;
    }

    public static Flight getFlightByID(Integer id) throws SQLException {

        Connection conn = null;
        Flight flight = new Flight();

        try {
            conn = ConnectionService.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flight = flightDAO.readFlightByID(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return flight;
    }

    public static void bookingSimultaneousDelete(Booking booking, BookingUser bookingUser, FlightBookings flightBooking) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            bookingDAO.deleteBooking(booking);
            bookingUserDAO.deleteBookingUser(bookingUser);
            flightBookingDAO.deleteFlightBooking(flightBooking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    public static void bookingSimultaneousUpdate(Booking booking, BookingUser bookingUser, FlightBookings flightBooking) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            bookingDAO.updateBooking(booking);
            bookingUserDAO.updateBookingUser(bookingUser);
            flightBookingDAO.updateFlightBooking(flightBooking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    public static void bookingSimultaneousAdd(Booking booking, BookingUser bookingUser, FlightBookings flightBooking) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            FlightBookingsDAO flightBookingDAO = new FlightBookingsDAO(conn);
            bookingDAO.addBooking(booking);
            bookingUserDAO.addBookingUser(bookingUser);
            flightBookingDAO.addFlightBooking(flightBooking);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    public static List<Booking> getCancelledTickets() throws SQLException {

        Connection conn = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookings = bookingDAO.readCanceledBookings();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }

        return bookings;
    }
}