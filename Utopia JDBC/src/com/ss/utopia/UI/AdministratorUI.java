package com.ss.utopia.UI;

import java.sql.SQLException;
import java.util.Scanner;

public class AdministratorUI {

    static Scanner input = new Scanner(System.in);
    static String option = "0";

    public static void adminMainMenu() throws SQLException {
        System.out.println("Please select an option:");
        System.out.println("\t1.) Add/Update/Delete/Read Flights");
        System.out.println("\t2.) Add/Update/Delete/Read Seats");
        System.out.println("\t3.) Add/Update/Delete/Read Tickets");
        System.out.println("\t4.) Add/Update/Delete/Read Airports");
        System.out.println("\t5.) Add/Update/Delete/Read Travelers");
        System.out.println("\t6.) Add/Update/Delete/Read Employees");
        System.out.println("\t7.) Override Ticket Cancellation");
        System.out.println("\t8.) Quit to previous");
        System.out.print("Enter your selection: ");

        // loop until valid input, only 1-3
        while (!option.matches("^[1-8]$")){
            System.out.print("Enter your selection: ");
            getAdminMenu(input.nextLine());
        }
    }

    // sets the user up with the next menu choice
    private static void getAdminMenu(String menu) throws SQLException {
        // switch case with numbers for menu
        switch (menu) {
            case "1":
                FlightCRUDMenu.mainMenu();
            case "2":
                SeatCRUDMenu.mainMenu();
            case "3":
                TicketCRUDMenu.mainMenu();
            case "4":
                AirportCRUDMenu.mainMenu();
            case "5":
                TravelerCRUDMenu.mainMenu();
            case "6":
                EmployeeCRUDMenu.mainMenu();
            case "7":
                TicketOverrideMenu.mainMenu();
            case "8":
                UI.mainUI();
            default:
                System.out.print("Invalid selection. Try again: ");
        }
    } // getMenu

    public interface CRUDMenu {
        Scanner scanner = new Scanner(System.in);

        void mainMenu() throws SQLException;
        void addMenu() throws SQLException;
        void updateMenu() throws SQLException;
        void deleteMenu() throws SQLException;
        void readMenu() throws SQLException;
    }



}