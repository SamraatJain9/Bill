package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static final String FILENAME = "src/data/data.csv"; // Define the filename as a class-level constant
    public static void main(String[] args) throws FileNotFoundException {
        // Read food items from CSV file
        List<String> foodItems = null;
        try {
            // Read food items from CSV file
            foodItems = readFoodItemsFromCSV(FILENAME);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
            return; // Exit the program
        }

        // Randomly select 1 to 5 items
        Random random = new Random();
        int numItems = random.nextInt(5) + 1; // Random number between 1 and 5
        Set<String> selectedItems = new HashSet<>();
        while (selectedItems.size() < numItems) {
            int randomIndex = random.nextInt(foodItems.size());
            selectedItems.add(foodItems.get(randomIndex));
        }

        // Define a map to store the quantity of each food item ordered
        Map<String, Integer> order = new HashMap<>();
        for (String item : selectedItems) {
            // Randomly select quantity between 1 and 3
            int quantity = random.nextInt(3) + 1; // Random number between 1 and 3
            order.put(item, quantity);
        }

        // Print the bill header
        System.out.println("               ~RESTAURANT NAME~");
        System.out.println("===============================================");
        System.out.println("               RESTAURANT");
        System.out.println("            141 PEARL STREET");
        System.out.println("      Compliments of GENES AAA restaurant");
        System.out.println("===============================================");
        System.out.println("                  BILL OF FARE");

        // Print the bill items
        System.out.println("Item            Price        Quantity       Total");
        System.out.println("-------------------------------------------------");
        double totalAmount = 0.0;
        for (String item : order.keySet()) {
            double price = getPriceForItem(item); // Get price for the item from CSV or elsewhere
            int quantity = order.get(item);
            double itemTotal = price * quantity;
            totalAmount += itemTotal;
            System.out.printf("%-15s ₹%-12.2f %-10d ₹%.2f%n", item, price, quantity, itemTotal);
        }

        // Print the total amount
        System.out.println("-------------------------------------------------");
        System.out.printf("Total: ₹%.2f%n", totalAmount);
    }

    private static List<String> readFoodItemsFromCSV(String filename) throws FileNotFoundException {
        if (!Files.exists(Paths.get(filename))) {
            throw new FileNotFoundException(); // Throw FileNotFoundException if file does not exist
        }
        List<String> foodItems = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0){
                    foodItems.add(parts[0].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodItems;
    }

    private static double getPriceForItem(String item) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split the line by comma
                if (parts.length > 1 && parts[0].trim().equalsIgnoreCase(item)) {
                    // Check if the first part matches the item and if there's a price at index 1
                    return Double.parseDouble(parts[1].trim()); // Return the price
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return a default price if item is not found or there's an error reading the file
        return 0.0; // Or any other default value you prefer
    }

}
