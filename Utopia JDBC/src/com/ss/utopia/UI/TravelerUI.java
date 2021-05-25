package com.ss.utopia.UI;

import com.ss.utopia.entity.*;
import com.ss.utopia.service.FlightService;
import com.ss.utopia.service.ServiceUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelerUI {
    static User user = new User();
    static Scanner input = new Scanner(System.in);

    // displays TRAV1 menu
    public void travMainMenu() throws SQLException {
        Scanner input = new Scanner(System.in); // scanner obj for input

        // prompt user for member number and check it
        System.out.print("\nEnter your Membership Number: ");
        user = ServiceUtils.getUserByID(input.nextInt());

        // call travOptsMenu after validation
        travOptsMenu();
    } // travMainMenu

    public static void travOptsMenu() throws SQLException {
        System.out.println("\nPlease select an option:");
        // give options to user
        System.out.println("\t1.) Book a ticket");
        System.out.println("\t2.) Cancel an upcoming trip");
        System.out.println("\t3.) Quit to previous");
        System.out.print("Enter your selection: ");

        // repeat while invalid
        while (!input.toString().matches("^[1-3]$")) {
            getOptsMenu(input.nextLine());
        } // while
    } // travOptsMenu

    private static void getOptsMenu(String menu) throws SQLException {
        // switch case with numbers for menu
        switch (menu){
            case "1":
                // booking menu
                travelerBookingMenu();
                break;
            case "2":
                // cancel menu
                travelerCancelMenu();
                break;
            case "3":
                // previous menu
                UI.mainUI();
                break;
            default:
                System.out.print("Invalid Selection. Try again: ");
        } // switch
    } // getOptsMenu

    public static void travelerBookingMenu() throws SQLException {
        List<Flight> flights;
        FlightService flightService = new FlightService();
        List<Flight> availableFlights = new ArrayList<>();
        Integer currCount = 1;
        String R_ARROW = " \u2192 ";
        String option = "0";
        int numOpt = Integer.parseInt(option);
        Flight selectedFlight = new Flight();

        System.out.println("\nPick the flight for which you would like to book a ticket.");

        // gets all the flights in a list
        flights = flightService.getAll();
        Flight flight1 = flights.get(0);
        System.out.println(flight1.getAirplane());

        // add only flights with open seats to a list
        for (Flight flight : flights) {
            if (flight.getAirplane().getType().getMaxCapacity() - flight.getReservedSeats() > 0) {
                availableFlights.add(flight);
            }
        }

        // display each flight with available seats
        // each line will be as follows:
        // AirportCode, City -> AirportCode, City
        for (Flight flight : availableFlights) {
            System.out.println(currCount + ".) " +
                    flight.getRoute().getOrigin().getAirportCode() + ", " + flight.getRoute().getOrigin().getCity()
                    + R_ARROW +
                    flight.getRoute().getDestination().getAirportCode() + ", " + flight.getRoute().getDestination().getCity());
            // increment counter for menu options
            currCount++;
        } // for

        // last menu option
        System.out.println(currCount + ".) Quit to previous");

        // loop until good input
        while ((numOpt > 0) && (numOpt < availableFlights.size())) {
            option = input.nextLine();
            numOpt = Integer.parseInt(option);

            if ((numOpt > 0) && (numOpt < availableFlights.size())) {
                System.out.print("Invalid selection. Please try again. ");
            } // if
        } // while

        // use if/else if since currCount is not constant expression
        if (numOpt == currCount) {
            travOptsMenu();
        } else if (numOpt <= availableFlights.size()) {
            selectedFlight = availableFlights.get(numOpt - 1);
        } // if else

        // get number of seats
        System.out.print("Enter the number of seats would you like to book:");
        option = input.nextLine();
        numOpt = Integer.parseInt(option);
        int numSeatsAvailable = selectedFlight.getAirplane().getType().getMaxCapacity() - selectedFlight.getReservedSeats();

        // loop until good input
        while ((numOpt > 0) && (numOpt <= numSeatsAvailable)) {
            option = input.nextLine();
            numOpt = Integer.parseInt(option);

            if ((numOpt > 0) && (numOpt < numSeatsAvailable)) {
                System.out.print("Invalid selection. Please try again. ");
            } // if
        } // while

        // update number of reserved seats for the selected flight
        selectedFlight.setReservedSeats(selectedFlight.getReservedSeats() + numOpt);

        FlightService selectedFlightService = new FlightService();

        // create pieces to add a booking update
        Booking booking = new Booking(true, genConfirmCode());
        FlightBookings flightBooking = new FlightBookings(selectedFlight, booking);
        BookingUser bookingUser = new BookingUser(booking, user);

        ServiceUtils.bookingSimultaneousAdd(booking, bookingUser, flightBooking);
        selectedFlightService.update(selectedFlight);
    } // travelerBookingMenu

    // generates a random string of alphanumeric characters as a confirmation code
    // size count may be changed
    public static String genConfirmCode() {
        int length = 7;
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();

        // loop through for specific length of confirmation code
        while (length-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    // goes through the canceling process for a traveler
    private static void travelerCancelMenu() throws SQLException {
        // get info of user
        List<Booking> bookings = ServiceUtils.getBookingsByUser(user);
        List<Flight> flights = ServiceUtils.getFlightsByUser(user);
        int currCount = 1;
        String R_ARROW = " \u2192 ";
        String option = "0";
        int numOpt = Integer.parseInt(option);
        Flight selectedFlight;
        Booking selectedBooking;

        System.out.println("Please pick the booking you would like to cancel: ");

        // for each booking show each flight
        for (Booking booking: bookings) {
            for (Flight flight : flights) {
                System.out.println(currCount + ".) " +
                        flight.getRoute().getOrigin().getAirportCode() + ", " + flight.getRoute().getOrigin().getCity()
                        + R_ARROW +
                        flight.getRoute().getDestination().getAirportCode() + ", " + flight.getRoute().getDestination().getCity());
            } // inner for
            currCount++;
        } // outer for


        // display the option to go to previous menu
        System.out.println(currCount + ".) Quit to previous");

        // loop until good input
        while ((numOpt < 0) && (numOpt <= currCount)) {
            option = input.nextLine();
            numOpt = Integer.parseInt(option);

            if ((numOpt > 0) && (numOpt <= currCount )) {
                System.out.print("Invalid selection. Please try again. ");
            }
        } // while

        // if selected quit, else continue cancel booking
        if (numOpt == currCount) {
            travOptsMenu();
        } else {
            selectedFlight = flights.get(numOpt - 1);
            selectedBooking = bookings.get(numOpt - 1);

            // confirm cancel
            System.out.println("You've successfully canceled your booking for: " +
                    selectedFlight.getRoute().getOrigin().getAirportCode() + ", " + selectedFlight.getRoute().getOrigin().getCity()
                    + R_ARROW +
                    selectedFlight.getRoute().getDestination().getAirportCode() + ", " + selectedFlight.getRoute().getDestination().getCity());

            // commit cancel and return to main menu
            ServiceUtils.cancelBooking(selectedBooking);
            UI.mainUI();
        } // if else
    }
} // TravelerUI
