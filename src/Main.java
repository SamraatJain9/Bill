package src;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Double> menu = new HashMap<>();
        menu.put("Burger", 10.99);
        menu.put("Pizza", 12.50);
        menu.put("Salad", 8.99);

        Map<String, Integer> order = new HashMap<>();
        order.put("Burger", 2);
        order.put("Pizza", 1);

        System.out.println("               ~RESTAURANT NAME~");
        System.out.println("===============================================");
        System.out.println("               RESTAURANT");
        System.out.println("            141.PEARL.STREET");
        System.out.println("      Compliments of GENES AAA restaurant");
        System.out.println("===============================================");
        System.out.println("                  BILL OF FARE\n");

        // Print the bill items
        System.out.println("Item            Price        Quantity       Total");
        System.out.println("-----------------------------------------------");

        double totalAmount = 0.0;
        for (String item : order.keySet()) {
            double price = menu.get(item);
            int quantity = order.get(item);
            double itemTotal = price * quantity;
            totalAmount += itemTotal;
            System.out.printf("%-15s $%-12.2f %-10d $%.2f%n", item, price, quantity, itemTotal);

            // Print the total amount
            System.out.println("-----------------------------------------------");
            System.out.printf("Total: $%.2f%n", totalAmount);
        }
    }
}
