package src;

import src.assets.Generate_Bill;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("A menu");

        JMenuItem menuItem1 = new JMenuItem("Text");
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("Images");
        menu.add(menuItem2);

        menu.addSeparator();
        JRadioButtonMenuItem menuItem3 = new JRadioButtonMenuItem("Files");
        menu.add(menuItem3);

        JRadioButtonMenuItem menuItem4 = new JRadioButtonMenuItem("Folders");
        menu.add(menuItem4);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
