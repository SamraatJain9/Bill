package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MenuItemAction {
    void execute();
}

class MenuItem {
    private String label;
    private MenuItemAction action;

    public MenuItem(String label, MenuItemAction action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public void select() {
        action.execute();
    }
}

class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(STR."\{i + 1}. \{items.get(i).getLabel()}");
            }
            System.out.print("Choose an option: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                if (choice > 0 && choice <= items.size()) {
                    items.get(choice - 1).select();
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
    }
}
