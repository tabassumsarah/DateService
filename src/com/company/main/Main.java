package com.company.main;

import com.company.main.date.DateService;
import com.company.main.date.DateServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to date service program. Enter q to exit! \n");

        while (true) {
            System.out.print("\nEnter first date (yyyy-mm-dd): ");
            // get input as a String
            String date1 = scanner.next();

            if ("q".equals(date1)) {
                System.out.println("Thank you for using our service. Program is terminating now!");
                break;
            }
            // prompt for Second Date
            System.out.print("\nEnter Second date (yyyy-mm-dd): ");

            // get input as a String
            String date2 = scanner.next();

            if ("q".equals(date2)) {
                System.out.println("Thank you for using our service. Program is terminating now!");
                break;
            }

            DateService service = new DateServiceImpl();
            try {
                System.out.print("Difference between dates is " + service.getDaysBetweenTwoDates(date1, date2) + " days.\n");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

        scanner.close();
        //  prompt for the First Date

    }
}
