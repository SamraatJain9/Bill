package src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {

    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";
    private static final int HASH_LENGTH = 7;

    public static String Username() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");

        String username = scanner.nextLine();
        System.out.println(STR."Hello, \{username}");
        return username;
    }

    public static String generateHash(String input) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b: hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('O');
                hexString.append(hex);
            }

            String truncatedHash = hexString.substring(0, HASH_LENGTH);

            return truncatedHash.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateRandomHash() {
        Random random = new Random();
        StringBuilder hash = new StringBuilder();
        for (int i = 0; i < HASH_LENGTH; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            hash.append(ALLOWED_CHARACTERS.charAt(randomIndex));
        }
        return hash.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String hash = generateHash(Username());
            System.out.println(STR."ID: \{hash}");

            String randomHash = generateRandomHash();
            System.out.println(STR."PASSKEY: \{randomHash}");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")){
                System.out.println("Exiting...");
                break;
            }



        }

        scanner.close();
    }
}




