package com.ss.utopia.dao;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.FlightBookings;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingsDAO extends BaseDAO<FlightBookings> {

    public FlightBookingsDAO(Connection conn) {
        super(conn);
    }

    public void addFlightBooking(FlightBookings flightBooking) throws SQLException {
        save("INSERT into flight_bookings (flight_id, booking_id) values (?, ?)",
                new Object[] {flightBooking.getId().getId(), flightBooking.getBooking().getId()});
    }

    public void updateFlightBooking(FlightBookings flightBooking) throws SQLException {
        save("UPDATE flight_bookings flight_id = ?, booking_id = ?",
                new Object[] {flightBooking.getId().getId(), flightBooking.getBooking().getId()});
    }

    public void deleteFlightBooking(FlightBookings flightBooking) throws SQLException {
        save("DELETE from flight_bookings where booking_id = ?", new Object[] {flightBooking.getBooking().getId()});
    }

    public List<FlightBookings> readAllFlightBookings() throws SQLException, ClassNotFoundException {
        return read("SELECT * from flight_bookings", null);
    }

    public FlightBookings getFlightBookingByBooking(Booking booking) throws SQLException, ClassNotFoundException {
        List<FlightBookings> flightBookings = read("SELECT * from flight_bookings where booking_id = ?",  new Object[] {booking.getId()});
        return flightBookings.get(0);
    }

    @Override
    protected List<FlightBookings> getData(ResultSet results) throws SQLException {
        List<FlightBookings> flightBookings = new ArrayList<>();
        while (results.next()) {
            FlightBookings flightBooking = new FlightBookings();
            flightBooking.getId().setId(results.getInt("flight_id"));
            flightBooking.getBooking().setId(results.getInt("booking_id"));
        }
        return flightBookings;
    }
}