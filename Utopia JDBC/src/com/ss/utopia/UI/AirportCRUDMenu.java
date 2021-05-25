package com.ss.utopia.UI;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.AirportService;

import java.sql.SQLException;
import java.util.List;

import static com.ss.utopia.service.AirportService.*;

public class AirportCRUDMenu implements AdministratorUI.CRUDMenu {

    @Override
    public static void mainMenu() throws SQLException {
        System.out.println("Please select an option: ");
        System.out.println("\t1.) Add airports");
        System.out.println("\t2.) Update airports");
        System.out.println("\t3.) Delete airports");
        System.out.println("\t4.) View all airports");
        System.out.println("\t5.) Quit to previous menu");
        System.out.print("Enter your selection: ");

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

        Airport airport = new Airport();

        System.out.print("Enter airport code: ");
        airport.setAirportCode(scanner.next().toUpperCase());

        System.out.print("Enter airport city: ");
        airport.setCity(scanner.next());

        System.out.println("Creating airport " + airport.getAirportCode() + " in " + airport.getCity());
        add(airport);
        System.out.println("Airport added");

        mainMenu();
    }

    @Override
    public void updateMenu() throws SQLException {

        List<Airport> airports = getAll();
        Airport airport = new Airport();
        Integer currCount = 1;

        System.out.println("Please select which Airport you would like to update.");

        for (Airport a : airports) {
            System.out.println(currCount + ".) " + airport.getAirportCode() + ", " + airport.getCity());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous");

        Integer response = scanner.nextInt();

        if (response == currCount) {
            mainMenu();
        } else if (response <= airports.size()) {
            airport = airports.get(response - 1);
        } else {
            System.out.println("Invalid selection. Try again");
            updateMenu();
        }

        System.out.println("Enter the new airport code code, or type N/A for no change");
        String input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Airport code not updated");
        } else {
            airport.setAirportCode(input);
        }

        System.out.println("Enter the new city, or type N/A for no change");
        input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Airport code not updated");
        } else {
            airport.setCity(input);
        }

        update(airport);
        System.out.println("Airport updated!");

        mainMenu();
    }

    @Override
    public void deleteMenu() throws SQLException {

        List<Airport> airports = getAll();
        Airport airport = new Airport();
        Integer currCount = 1;

        System.out.println("Select which airport to delete:");

        for (Airport a : airports) {
            System.out.println(currCount + ".) " + airport.getAirportCode() + ", " + airport.getCity());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous");

        Integer response = scanner.nextInt();

        if (response == currCount) {
            mainMenu();
        } else if (response <= airports.size()) {
            airport = airports.get(response - 1);
        } else {
            System.out.println("Invalid selection. Try again");
            deleteMenu();
        }

        AirportService.delete(airport);
        System.out.println("Airport deleted");

        mainMenu();
    }

    @Override
    public void readMenu() throws SQLException {

        List<Airport> airports = AirportService.getAll();

        System.out.println("What airport would you like to delete?");

        for (Airport airport : airports) {
            System.out.println("Airport " + airport.getAirportCode() + ", " + airport.getCity());
        }

        System.out.println("Press 'enter' to return to the previous menu");
        scanner.nextLine(); scanner.nextLine();

        mainMenu();
    }
}
