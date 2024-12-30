import java.util.Scanner;

public class NameGen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask questions
        System.out.println("Welcome to the Name Generator!");
        System.out.print("What is your favorite color? ");
        String color = scanner.nextLine();

        System.out.print("What is your favorite animal? ");
        String animal = scanner.nextLine();

        System.out.print("What is your lucky number? ");
        String number = scanner.nextLine();

        // Generate a name
        String generatedName = color + animal + number;

        // Display the generated name
        System.out.println("Your generated name is: " + generatedName);

        // Close the scanner
        scanner.close();
    }
}
