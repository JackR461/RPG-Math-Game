/*
 * -How make 'beastiary'? (list of premade enemies/boons to then pick one from)
 *      -files to sort?
 * -UI
 * -ReadMe
 * -
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Test");
        Enemy enemy = new Enemy("Enemy", 2, 2);

        Combat combat = new Combat(player, enemy);
        combat.run();


    }


    // TODO: Introduction/Tutorial/CharacterCreation

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

    /* Used to generate the generic list of enemies
     * A player will face for WorldMap.
     * 
     * Enemy constructor:
     *   String name, int level, int XP,
     *   int maxHP, int currentHP, int strength, int defense,
     *   int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
     *   int numAttacks, int speed
     */
    private ArrayList<Enemy> generateEnemyList() {
        ArrayList<Enemy> genericEnemyEncounters = new ArrayList<>();
        Enemy enemy1 = new Enemy
                            ("Swordsperson", 1, 15, 
                            25, 25, 2, 1, 
                            1, 5, 1, 3, 
                            2, 2);
        genericEnemyEncounters.add(enemy1);
        Enemy enemy2 = new Enemy
                            ("Shieldsperson", 1, 15,
                            20, 20, 1, 3,
                            0, 30, 5, 2, 
                            1, 5);
        genericEnemyEncounters.add(enemy2);
        Enemy enemy3 = new Enemy
                            ("Robot", 1, 15,
                            15, 15, 2, 3, 
                            0, 1, 1, 8,
                            1, 3);
        genericEnemyEncounters.add(enemy3);
        Enemy enemy4 = new Enemy
                            ("Triangle Wielder", 1, 15,
                            33, 33, 1, 0, 
                            3, 9, 3, 3,
                            3, 3);
        genericEnemyEncounters.add(enemy4);
        Enemy enemy5 = new Enemy
                            ("Giant", 1, 15,
                            50, 50, 2, 0, 
                            10, 30, 1, 2,
                            1, 5);
        genericEnemyEncounters.add(enemy5);
        Enemy enemy6 = new Enemy
                            ("Archer", 1, 15,
                            40, 40, 1, 1, 
                            0, 8, 2, 2,
                            2, 2);
        genericEnemyEncounters.add(enemy6);
        // Return list of generic enemy encounters
        return genericEnemyEncounters;
    }


}
