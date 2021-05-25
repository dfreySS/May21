package com.ss.utopia.UI;

import com.ss.utopia.entity.*;
import com.ss.utopia.service.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class TicketCRUDMenu implements AdministratorUI.CRUDMenu {

    Random random = new Random();
    FlightService flightService = new FlightService();
    UserService userService = new UserService();
    BookingService bookingService = new BookingService();

    @Override
    public static void mainMenu() throws SQLException {
        System.out.println("Please select an currCount:");
        System.out.println("\t1.) Add tickets");
        System.out.println("\t2.) Update tickets");
        System.out.println("\t3.) Delete tickets");
        System.out.println("\t4.) View all tickets");
        System.out.println("\t5.) Quit to previous");

        String response = scanner.next();

        switch (response) {
            case "1":
                addMenu();
            case "2":
                updateMenu();
            case "3":
                deleteMenu();
            case "4":
                readMenu();
            case "5":
                AdministratorUI.adminMainMenu();
            default:
                System.out.println("Invalid selection. Try again");
                mainMenu();
        }
    }

    @Override
    public void addMenu() throws SQLException {
        Flight flight;
        User user = new User();

        System.out.println("What user ID is this ticket for?");
        List<User> users = userService.getAll();
        for (User u : users) {
            System.out.println("User " + user.getId() + ": " + user.getGivenName() + " " + user.getFamilyName());
        }
        user = ServiceUtils.getUserByID(scanner.nextInt());

        System.out.println("Enter flight ID for ticket");
        List<Flight> flights = flightService.getAll();
        for (Flight f : flights) {
            System.out.println(f.getRoute().getOrigin().getAirportCode() + " \u2192 " + f.getRoute().getDestination().getAirportCode());
        }
        flight = ServiceUtils.getFlight(scanner.nextInt());

        int confirmationCode = random.nextInt();

        Booking booking = new Booking(true, String.valueOf(confirmationCode));
        FlightBookings flightBooking = new FlightBookings(flight, booking);
        BookingUser bookingUser = new BookingUser(booking, user);

        ServiceUtils.bookingSimultaneousAdd(booking, bookingUser, flightBooking);

        System.out.println("Ticket added!");
        mainMenu();
    }

    @Override
    public void updateMenu() throws SQLException {

        System.out.println("Select ticket to update");
        List<Booking> bookings = bookingService.getAll();
        for (Booking booking : bookings) {
            BookingUser bookingUser = ServiceUtils.getBookingUserByBooking(booking);
            FlightBookings flightBookings = ServiceUtils.getFlightBookingByBooking(booking);

            System.out.println("Ticket " + booking.getId() + " for " + bookingUser.getUser().getGivenName() + " " + bookingUser.getUser().getGivenName() +
                    " on flight " + flightBookings.getId().getId());
        }

        System.out.println("Or type 0 to cancel and Quit to previous");

        int response = scanner.nextInt();

        if (response == 0) {
            mainMenu();
        }

        Booking booking = ServiceUtils.getBookingByID(response);
        BookingUser bookingUser = ServiceUtils.getBookingUserByBooking(booking);
        FlightBookings flightBookings = ServiceUtils.getFlightBookingByBooking(booking);

        System.out.println("Enter the new flight ID or type N/A for no change");
        if (scanner.hasNextInt()) {
            flightBookings.setId(ServiceUtils.getFlightByID(scanner.nextInt()));
        } else if (scanner.next().equalsIgnoreCase("n/a")) {
            System.out.println("No changes made to flight");
        } else {
            System.out.println("Invalid option. Try again.");
            updateMenu();
        }

        System.out.println("Enter the new user ID or type N/A for no change");
        if (scanner.hasNextInt()) {
            bookingUser.setUser(ServiceUtils.getUserByID(scanner.nextInt()));
        } else if (scanner.next().equalsIgnoreCase("n/a")) {
            System.out.println("No changes made to flight");
        } else {
            System.out.println("Invalid option. Try again.");
            updateMenu();
        }

        System.out.println("Please enter 1 for an active booking, 0 for an inactive booking, or N/A for no change");
        if (scanner.hasNextInt()) {
            response = scanner.nextInt();
            if (response == 1 || response == 0) {
                if (response == 1)
                    booking.setActive(Boolean.TRUE);
                else
                    booking.setActive(Boolean.FALSE);
            } else {
                System.out.println("Invalid option. Try again.");
                updateMenu();
            }
        } else if (scanner.next().equalsIgnoreCase("n/a")) {
            System.out.println("No changes made to flight");
        } else {
            System.out.println("Invalid option. Try again.");
            updateMenu();
        }

        ServiceUtils.bookingSimultaneousUpdate(booking, bookingUser, flightBookings);

        System.out.println("Updates made successfully!");
        mainMenu();
    }

    @Override
    public void deleteMenu() throws SQLException {

        System.out.println("Which Ticket ID would you like to delete?");
        List<Booking> bookings = bookingService.getAll();
        for (Booking booking : bookings) {
            BookingUser bookingUser = ServiceUtils.getBookingUserByBooking(booking);
            FlightBookings flightBookings = ServiceUtils.getFlightBookingByBooking(booking);

            System.out.println("Ticket " + booking.getId() + " for " + bookingUser.getUser().getGivenName() + " " + bookingUser.getUser().getGivenName() +
                    " on flight " + flightBookings.getId().getId());
        }

        System.out.println("Or type 0 to delete none and Quit to previous");

        int response = scanner.nextInt();

        if (response == 0) {
            mainMenu();
        }

        Booking booking = ServiceUtils.getBookingByID(response);
        BookingUser bookingUser = ServiceUtils.getBookingUserByBooking(booking);
        FlightBookings flightBooking = ServiceUtils.getFlightBookingByBooking(booking);

        ServiceUtils.bookingSimultaneousDelete(booking, bookingUser, flightBooking);
        System.out.println("Ticket Deleted");

        mainMenu();
    }

    @Override
    public void readMenu() throws SQLException {
        List<Booking> bookings = bookingService.getAll();
        for (Booking booking : bookings) {
            FlightBookings flightBooking = ServiceUtils.getFlightBookingByBooking(booking);
            BookingUser bookingUser = ServiceUtils.getBookingUserByBooking(booking);
            System.out.println("Ticket " + booking.getId() + " for " + bookingUser.getUser().getGivenName() + " " + bookingUser.getUser().getGivenName() +
                    " on flight " + flightBooking.getId().getId());
        }

        System.out.println("Press 'enter' to quit to previous");
        scanner.nextLine(); scanner.nextLine();

        mainMenu();
    }
}