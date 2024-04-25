// Main.java
package src;

import src.assets.Generate_Bill;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        displayMenu(); // Display the initial menu
    }

    private static void displayMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Menu:");
            System.out.println("1. Generate Bill");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Generate_Bill.generateBill();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (!exit);
        System.out.println("Exiting the program. Thank you!");
    }
}
