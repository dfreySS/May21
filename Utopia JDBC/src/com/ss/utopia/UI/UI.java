package com.ss.utopia.UI;

import java.sql.SQLException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws SQLException {
        UI.mainUI();
    }
}

// Class to present the user a simple cmd line interface
public class UI {
    private static String currMenu = "0";   // keeps track of the menu selection

    // main menu ui where user selects user type
    public static void mainUI() throws SQLException {
        Scanner input = new Scanner(System.in);

        // display main menu
        System.out.println("\nWelcome to Utopia Airlines Management System. Please select a user category: ");
        System.out.println("\t 1.) Employee \n" +
                "\t 2.) Administrator \n" +
                "\t 3.) Traveler");

        // loop until valid input, only 1-3
        while (!currMenu.matches("^[1-3]$")) {
            System.out.print("Enter your selection: ");
            getMenu(currMenu = (input.nextLine()));
        }
    }

    // sets the user up with the next menu choice
    private static void getMenu(String menu) throws SQLException {
        // switch case with numbers for menu
        switch (menu){
            case "1":
                // Employee
                new EmployeeUI().empMainMenu();
                break;
            case "2":
                // Administrator
                new AdministratorUI().adminMainMenu();
                break;
            case "3":
                // Traveler
                new TravelerUI().travMainMenu();
                break;
            default:
                System.out.printf("Invalid Selection. Try again: ");
        } // switch
    } // getMenu
} // UI
