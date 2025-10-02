/*
 * -How make 'beastiary'? (list of premade enemies/events/ect... to then pick one from)
 * -UI
 * -
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // The character the user plays as
        Player pc = new Player("Test");




    }


    // Introduction/Tutorial
    public static void introTutorial() {
        // TODO: introduction/tutorial function
    }

    public static Player createCharacter(String name) {
        Player player = new Player(name);
        return player;
    }

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
        options += "]";
        System.out.print(options + ": ");
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
