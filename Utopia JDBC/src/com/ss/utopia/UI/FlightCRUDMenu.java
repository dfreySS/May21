package com.ss.utopia.UI;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.FlightService;

import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlightCRUDMenu implements AdministratorUI.CRUDMenu {
    String R_ARROW = " \u2192 ";
    FlightService flightService = new FlightService();

    @Override
    public static void mainMenu() throws SQLException {
        System.out.println("Please select an option:");
        System.out.println("\t1.) Add flights");
        System.out.println("\t2.) Update flights");
        System.out.println("\t3.) Delete flights");
        System.out.println("\t4.) View all flights");
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

        Flight flight = new Flight();
        String response;

        System.out.println("Enter airport origin code:");
        response = scanner.next().toUpperCase();
        flight.getRoute().getOrigin().setAirportCode(response);

        System.out.println("Enter airport destination code:");
        response = scanner.next().toUpperCase();
        flight.getRoute().getDestination().setAirportCode(response);

        System.out.println("Enter plane ID:");
        response = scanner.next();
        flight.getAirplane().setId(Integer.parseInt(response));

        System.out.println("Enter departure time in MM-DD-YYYY HH:MM format:");
        response = scanner.nextLine();
        flight.setDepartTime(LocalDateTime.parse(response, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")));

        System.out.println("Enter the number of reserved seats:");
        response = scanner.next();
        flight.setReservedSeats(Integer.parseInt(response));

        System.out.println("Enter ticket price:");
        response = scanner.next();
        flight.setSeatPrice(Float.parseFloat(response));

        FlightService.add(flight);
        System.out.println("Flight added!");

        mainMenu();
    }

    @Override
    public void updateMenu() throws SQLException {

        List<Flight> flights = FlightService.getAll();
        Flight flight = new Flight();
        Integer currCount = 1;
        String dateString = "";

        System.out.println("Select flight to update:");
        for (Flight f : flights) {
            System.out.println(currCount + ".) " +
                    flight.getRoute().getOrigin().getAirportCode() + ", " + flight.getRoute().getOrigin().getCity()
                    + R_ARROW +
                    flight.getRoute().getDestination().getAirportCode() + ", " + flight.getRoute().getDestination().getCity());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous.");

        Integer response = scanner.nextInt();
        if (response == currCount) {
            mainMenu();
        } else if (response <= flights.size()) {
            flight = flights.get(response - 1);
        } else {
            System.out.println("Invalid selection. Try again");
            updateMenu();
        }

        System.out.println("Type 'quit' at any time to cancel and Quit to previous");


        System.out.println("Please enter new origin airport ID or enter N/A for no change");
        String input = scanner.next();
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            mainMenu();
        } else if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Origin airport not updated");
        } else {
            flight.getRoute().getOrigin().setAirportCode(input.toUpperCase());
        }

        System.out.println("Please enter new destination airport ID or enter N/A for no change");
        input = scanner.next();
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            mainMenu();
        } else if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Destination airport not updated");
        } else {
            flight.getRoute().getDestination().setAirportCode(input.toUpperCase());
        }

        System.out.println("Please enter a new departure date as MM-DD-YYYY or enter N/A for no change");
        input = scanner.next();
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            mainMenu();
        } else if (input.equalsIgnoreCase("n/a")) {
            dateString = flight.getDepartTime().toLocalDate().toString();
            System.out.println("Departure date not updated");
        } else {
            dateString = input;
        }

        System.out.println("Please enter a new departure time as HH:MM or enter N/A for no change");
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("Canceling the update");
            mainMenu();
        } else if (input.equalsIgnoreCase("n/a")) {
            dateString = dateString.concat(flight.getDepartTime().toLocalTime().toString());
            System.out.println("Departure date not updated");
        } else {
            dateString = dateString.concat(" " + input);
        }

        flight.setDepartTime(LocalDateTime.parse(input, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")));

        FlightService.update(flight);
        System.out.println("Update successful!");

        mainMenu();
    }

    @Override
    public void deleteMenu() throws SQLException {

        List<Flight> flights = FlightService.getAll();
        Flight flight = new Flight();
        Integer currCount = 1;

        System.out.println("Select flight to delete:");
        for (Flight f : flights) {
            System.out.println(currCount + ".) " +
                    flight.getRoute().getOrigin().getAirportCode() + ", " + flight.getRoute().getOrigin().getCity()
                    + R_ARROW +
                    flight.getRoute().getDestination().getAirportCode() + ", " + flight.getRoute().getDestination().getCity());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous");

        Integer response = scanner.nextInt();

        if (response == currCount) {
            mainMenu();
        } else if (response <= flights.size()) {
            flight = flights.get(response - 1);
        } else {
            System.out.println("Invalid selection. Try again");
            deleteMenu();
        }

        FlightService.delete(flight);
        System.out.println("Flight deleted!");

        mainMenu();
    }

    @Override
    public void readMenu() throws SQLException {

        List<Flight> flights = FlightService.getAll();

        for (Flight f: flights) {
            System.out.println("Flight " + f.getId() + " from " + f.getRoute().getOrigin().getAirportCode() + " to " + f.getRoute().getDestination().getAirportCode());
        }

        System.out.println("Type any key to return to previous menu");
        String input = scanner.next();

        while (input.equals("")) {
            input = scanner.next();
        }

        System.out.println("Press enter to quit to previous");
        scanner.nextLine(); scanner.nextLine();

        mainMenu();
    }
}