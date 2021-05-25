package com.ss.utopia.UI;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.FlightService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    private List<Flight> flights = new ArrayList<>();
    private Flight flight = new Flight();
    private String R_ARROW = " \u2192 ";

    FlightService flightService = new FlightService();
    Scanner input = new Scanner(System.in);

    public void empMainMenu() throws SQLException {
        System.out.println("Please select an option:");
        System.out.println("\t1.) View managed flights");
        System.out.println("\t2.) Quit to previous");
        System.out.print("Enter your selection: ");

        // repeat while invalid
        while (!input.toString().matches("^[1-2]$")) {
            getOptsMenu(input.nextLine());
        } // while
    } // empMainMenu

    private void getOptsMenu(String menu) throws SQLException {
        // switch case with numbers for menu
        switch (menu){
            case "1":
                // manage flights menu
                empFlightsMenu();
                break;
            case "2":
                // previous menu
                UI.mainUI();
                break;
            default:
                System.out.print("Invalid Selection. Try again: ");
        } // switch
    } // getOptsMenu

    public void empFlightsMenu() throws SQLException {
        String option = "0";
        Integer numOpt = Integer.parseInt(option);

        flights = flightService.getAll();
        int currCount = 1;

        System.out.println("Please select an currCount:");

        // display the flights
        for (Flight flight : flights) {
            System.out.println(currCount + ".) " +
                    flight.getRoute().getOrigin().getAirportCode() + ", " + flight.getRoute().getOrigin().getCity()
                    + R_ARROW +
                    flight.getRoute().getDestination().getAirportCode() + ", " + flight.getRoute().getDestination().getCity());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous");

        // loop until good input
        while ((numOpt > 0) && (numOpt <= flights.size())) {
            option = input.nextLine();
            numOpt = Integer.parseInt(option);

            if ((numOpt > 0) && (numOpt < flights.size())) {
                System.out.print("Invalid selection. Please try again. ");
            } // if
        } // while

        if (numOpt == currCount) {
            empMainMenu();
        } else if (numOpt <= flights.size()) {
            flight = flights.get(numOpt - 1);
            empFlightMenu();
        }
    }

    private void empFlightMenu() throws SQLException {
        String option = "0";
        Integer numOpt = Integer.parseInt(option);

        System.out.println("Please select an option:");
        System.out.println("\t1.) View more details about this flight");
        System.out.println("\t2.) Update the details of this flight");
        System.out.println("\t3.) Add seats to this flight");
        System.out.println("\t4.) Quit to previous");
        System.out.print("Enter your selection: ");

        // repeat while invalid
        while (!input.toString().matches("^[1-4]$")) {
            getFlightMenu(input.nextLine());
        } // while
    } // empMainMenu

    private void getFlightMenu(String menu) throws SQLException {
        // switch case with numbers for menu
        switch (menu){
            case "1":
                // flight details
                empFlightDetails();
                break;
            case "2":
                // update flight
                empFlightUpdate();
                break;
            case "3":
                // add seats
                empFlightAddSeats();
                break;
            case "4":
                empFlightsMenu();
            default:
                System.out.print("Invalid Selection. Try again: ");
        } // switch
    } // getOptsMenu

    private void empFlightDetails() throws SQLException {

        System.out.println(flight.getRoute().getOrigin().getAirportCode() + R_ARROW +
                flight.getRoute().getDestination().getAirportCode());
        System.out.println("Departure date and time: " + flight.getDepartTime());
        System.out.println("Available Seats: " + (flight.getAirplane().getType().getMaxCapacity() - flight.getReservedSeats()));

        System.out.println("Press enter to return to the previous menu");
        input.nextLine(); input.nextLine();
    }

    private void empFlightUpdate() throws SQLException {

        String dateString = "";

        System.out.println(flight.getRoute().getOrigin().getAirportCode() + R_ARROW +
                flight.getRoute().getDestination().getAirportCode());

        System.out.println("Enter 'quit' at any prompt to cancel operation\n.");

        System.out.println("Please enter new Origin Airport ID or enter N/A for no change");
        String response = input.nextLine();
        if (response.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            empFlightMenu();
        } else if (response.equalsIgnoreCase("n/a")) {
            System.out.println("Origin airport not updated");
        } else {
            flight.getRoute().getOrigin().setAirportCode(response.toUpperCase());
        }

        System.out.println("Please enter new destination airport ID or enter N/A for no change");
        response = input.nextLine();
        if (response.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            empFlightMenu();
        } else if (response.equalsIgnoreCase("n/a")) {
            System.out.println("Destination airport not updated");
        } else {
            flight.getRoute().getDestination().setAirportCode(response.toUpperCase());
        }

        System.out.println("Please enter a new departure date as MM-DD-YYYY or enter N/A for no change");
        response = input.next();
        if (response.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            empFlightMenu();
        } else if (response.equalsIgnoreCase("n/a")) {
            dateString = flight.getDepartTime().toLocalDate().toString();
            System.out.println("Departure date not updated");
        } else {
            dateString = response;
        }

        System.out.println("Please enter a new departure time as HH:MM or enter N/A for no change");
        if (response.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            empFlightDetails();
        } else if (response.equalsIgnoreCase("n/a")) {
            dateString = dateString.concat(flight.getDepartTime().toLocalTime().toString());
            System.out.println("Departure date not updated");
        } else {
            dateString = dateString.concat(" " + response);
        }

        flight.setDepartTime(LocalDateTime.parse(response, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")));

        flightService.update(flight);
        System.out.println("Update successful!  returning to previous menu.");
        empFlightMenu();
    }

    public void empFlightAddSeats() throws SQLException {
        System.out.println("Current available seats: " + (flight.getAirplane().getType().getMaxCapacity() - flight.getReservedSeats()));
        System.out.println("How many seats would you like to add?");
        int response = input.nextInt();
        flight.setReservedSeats(flight.getReservedSeats() - response);

        flightService.update(flight);
        System.out.println("Successfully added " + response + "seats");
        empFlightDetails();
    }
}