import java.util.Scanner;

public class InputHelper {

    public static int getInt(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            try {
                return scanner.nextInt();

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public static String getString(Scanner scanner, String message) {

        System.out.print(message);
        return scanner.nextLine();
    }
}