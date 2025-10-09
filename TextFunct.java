import java.util.ArrayList;
import java.util.Scanner;

/*
 * Used to clean/guide user inputs for game options
 */

public class TextFunct {
    // Forces the user to enter an answer found within the array,
    // then returns that input
    public static String forceCorrectInput(ArrayList<String> inputs) {
        // Scanner to read user selection
        Scanner scanner = new Scanner(System.in);
        // Used to build question answered to user
        String options = "[";
        // Builds question
        for (int i = 0; i < inputs.size(); i++) {
            options += inputs.get(i);
            if (i < inputs.size()-1) {
                options += "/";
            }
        }
        options += "]: ";
        System.out.print(options);
        String userInput = scanner.next();
        // While input not in list of viable inputs, repeat question
        while (!(inputs.contains(userInput))) {
            System.out.println("Invalid selection");
            System.out.print(options + ": ");
            userInput = scanner.next();
        }
        // Return user input
        return userInput;
    }

    // Variation that takes a different kind of array of options
    public static String forceCorrectInput(String[] inputs) {
        Scanner scanner = new Scanner(System.in);
        String options = "[";
        for (int i = 0; i < inputs.length; i++) {
            options += inputs[i];
            if (i < inputs.length-1) {
                options += "/";
            }
        }
        options += "]: ";
        System.out.println(options);
        String userInput = scanner.next();
        while (!(inputs.contains(userInput))) {
            System.out.println("Invalid selection");
            System.out.print(options + ": ");
            userInput = scanner.next();
        }

        return userInput;

    }
    
    // Variation where the user only has one correct option
    public static String forceCorrectInput(String option) {
        Scanner scanner = new Scanner(System.in);
        String theOption = "["+option+"]: ";
        System.out.print(theOption);
        String userInput = scanner.next();
        while (!(userInput.equals(option))) {
            System.out.println("Invalid selection");
            System.out.print(theOption);
            userInput = scanner.next();
        }
        // Return user input
        return userInput;
    }
}
