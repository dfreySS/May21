package com.ss.utopia.UI;

import com.ss.utopia.entity.User;
import com.ss.utopia.entity.UserRole;
import com.ss.utopia.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeCRUDMenu implements AdministratorUI.CRUDMenu {
    UserRole employee = new UserRole(2);
    UserService userService = new UserService();

    @Override
    public static void mainMenu() throws SQLException {
        System.out.println("What would you like to do?");
        System.out.println("\t1.) Add employees");
        System.out.println("\t2.) Update employees");
        System.out.println("\t3.) Delete employees");
        System.out.println("\t4.) View all employees");
        System.out.println("\t5.) Quit to previous");
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

        User user = new User();
        user.setRole(employee);

        System.out.println("Enter user's given name");
        String response = scanner.next();
        user.setGivenName(response);

        System.out.println("Enter family name");
        response = scanner.next();
        user.setFamilyName(response);

        System.out.println("Enter user's username");
        response = scanner.next();
        user.setUsername(response);

        System.out.println("Enter user's email");
        response = scanner.next();
        user.setEmail(response);

        System.out.println("Enter user's password");
        response = scanner.next();
        user.setPassword(response);

        System.out.println("Enter user's phone number");
        response = scanner.next();
        user.setPhone(response);

        userService.add(user);
        System.out.println("User added successfully!");

        mainMenu();
    }

    @Override
    public void updateMenu() throws SQLException {

        List<User> employees = userService.getUsersByRole(employee);
        User user = new User();
        Integer currCount = 1;

        System.out.println("Select which user to update:");

        for (User u : employees) {
            System.out.println(currCount + ".) " + u.getId() + ": " + u.getGivenName() + " " + u.getFamilyName());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous");
        Integer response = scanner.nextInt();

        if (response == currCount) {
            mainMenu();
        } else if (response <= employees.size()) {
            user = employees.get(response - 1);
        } else {
            System.out.println("Invalid selection. Try again");
            updateMenu();
        }

        System.out.println("Enter the user's new given name, or type N/A to skip");
        String input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Given name not updated");
        } else {
            user.setGivenName(input);
        }

        System.out.println("Enter the user's new family name, or type N/A to skip");
        input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Family name not updated");
        } else {
            user.setFamilyName(input);
        }

        System.out.println("Enter the user's new username, or type N/A to skip");
        input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Username not updated");
        } else {
            user.setUsername(input);
        }

        System.out.println("Enter the user's new email, or type N/A to skip");
        input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Email not updated");
        } else {
            user.setEmail(input);
        }

        System.out.println("Enter the user's new password, or type N/A to skip");
        input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Password not updated");
        } else {
            user.setPassword(input);
        }

        System.out.println("Enter the user's new phone number, or type N/A to skip");
        input = scanner.next();
        if (input.equalsIgnoreCase("n/a")) {
            System.out.println("Phone not updated");
        } else {
            user.setPhone(input);
        }

        userService.update(user);
        System.out.println("User Updated Successfully");

        mainMenu();
    }

    @Override
    public void deleteMenu() throws SQLException {

        List<User> employees = userService.getUsersByRole(employee);
        User user = new User();
        Integer currCount = 1;

        System.out.println("Select which user to delete: ");

        for (User u : employees) {
            System.out.println(currCount + ".) " + u.getId() + ": " + u.getGivenName() + " " + u.getFamilyName());
            currCount++;
        }

        System.out.println(currCount + ".) Quit to previous");
        Integer response = scanner.nextInt();

        if (response == currCount) {
            mainMenu();
        } else if (response <= employees.size()) {
            user = employees.get(response - 1);
        } else {
            System.out.println("Invalid selection. Try again");
            updateMenu();
        }

        userService.delete(user);
        System.out.println("User Updated Successfully");

        mainMenu();
    }

    @Override
    public void readMenu() throws SQLException {

        List<User> employees = userService.getUsersByRole(employee);
        User user = new User();

        for (User u : employees) {
            System.out.println("User " + u.getId() + ": " + u.getGivenName() + " " + u.getFamilyName());
        }

        System.out.println("Press enter to return to previous menu");
        scanner.nextLine(); scanner.nextLine();

        mainMenu();
    }
}