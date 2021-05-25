package com.ss.utopia.dao;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingUserDAO extends BaseDAO<BookingUser> {
    public BookingUserDAO(Connection conn) {
        super(conn);
    }

    public void addBookingUser(BookingUser bookingUser) throws SQLException {
        save("INSERT into booking_user (booking_id, user_id) values (?, ?)", new Object[]
                {bookingUser.getBooking().getId(), bookingUser.getUser().getId()});
    }

    public void updateBookingUser(BookingUser bookingUser) throws SQLException {
        save("UPDATE booking_user set booking_id = ?, user_id = ?", new Object[] {bookingUser.getBooking().getId(), bookingUser.getUser().getId()});
    }

    public void deleteBookingUser(BookingUser bookingUser) throws SQLException {
        save("DELETE from booking_user where booking_id = ?", new Object[] {bookingUser.getBooking().getId()});
    }

    public List<BookingUser> readAllBookingUsers() throws SQLException, ClassNotFoundException {
        return read("SELECT * from booking_user", null);
    }

    public List<BookingUser> readBookingsByUser(User user) throws SQLException, ClassNotFoundException {
        return read("SELECT * from booking_user where user_id = ?", new Object[] {user.getId()});
    }

    public BookingUser readBookingUserByBooking(Booking booking) throws SQLException, ClassNotFoundException {
        List<BookingUser> bookingUsers = read("SELECT * from booking_user where booking_id = ?", new Object[] {booking.getId()});
        return bookingUsers.get(0);
    }

    @Override
    protected List<BookingUser> getData(ResultSet results) throws SQLException {
        List<BookingUser> bookingUsers = new ArrayList<>();
        while (results.next()) {
            BookingUser bookingUser = new BookingUser();
            bookingUser.getUser().setId(results.getInt("user_id"));
            bookingUser.getBooking().setId(results.getInt("booking_id"));
            bookingUsers.add(bookingUser);
        }

        return bookingUsers;
    }
}
