package com.ss.utopia.dao;

import com.ss.utopia.entity.Booking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends BaseDAO<Booking> {

    public BookingDAO(Connection conn) {
        super(conn);
    }

    public void addBooking(Booking booking) throws SQLException {
        save("INSERT into booking (is_active, confirmation_code) values (?, ?)", new Object[]
                {booking.getActive(), booking.getConfirmCode()});
    } // addBooking


    public void updateBooking(Booking booking) throws SQLException {
        save("UPDATE booking set is_active = ?", new Object[] {booking.getActive()});
    } // updateBooking

    public void deleteBooking(Booking booking) throws SQLException {
        save("DELETE from booking where id = ?", new Object[] {booking.getId()});
    } // deleteBooking

    public List<Booking> readAllBookings() throws SQLException, ClassNotFoundException {
        return read("SELECT * from booking", null);
    } // readAllBookings

    public Booking readBookingByID(Integer id) throws SQLException, ClassNotFoundException {
        List<Booking> bookings = read("SELECT * from booking where id = ?", new Object[] {id});
        return bookings.get(0);
    } // readBookingByID

    public List<Booking> readCanceledBookings() throws SQLException, ClassNotFoundException {
        return read("SELECT * from booking where is_active = '0'", null);
    } // readCanceledBookings

    @Override
    protected List<Booking> getData(ResultSet results) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        while (results.next()) {
            Booking booking = new Booking();
            booking.setId(results.getInt("id"));
            booking.setActive(results.getBoolean("is_active"));
            booking.setConfirmCode("confirmation_code");
            bookings.add(booking);
        } // while
        return bookings;
    } // getData
} // BookingDAO