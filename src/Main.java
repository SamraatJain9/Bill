package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Option 1", () -> System.out.println("You selected option 1")));
        menu.addItem(new MenuItem("Option 2", () -> System.out.println("You selected option 2")));
        menu.addItem(new MenuItem("Exit", () -> System.exit(0)));

        menu.display();
    }
}


