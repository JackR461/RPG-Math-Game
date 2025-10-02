import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/* Using Random:
 *   Random random = new Random();
 *   int randInt = random.nextInt(2);   //generates random number of 1 or 0
 */


/*
 * Used to host fights between two fighters.
 * A combat ends when one fighter runs out of HP.
 * The result of the fight can be found in the victory boolean
 */
public class Combat {

    // Attributes:
    // Difficulty levels used for determining Player attack speed
    private final int DIFF_LVL_5 = 0;    // Difficulty (Hard+)
    private final int DIFF_LVL_4 = 1;    // Difficulty (Hard)
    private final int DIFF_LVL_3 = 2;    // Difficulty (Medium)
    private final int DIFF_LVL_2 = 4;    // Difficulty (Easy)
    private final int DIFF_LVL_1 = 10;   // Difficulty (Easy+)
    // Charge requirement needed for determining bonus damage
    private final int CHARGE_COST = 10;
    private final int CHARGE_BONUS_DAMAGE = 10;
    // User options for charge_cost
    private final ArrayList<String> chargeOptions = new ArrayList<>();
    // Logs combat
    private boolean victory;    // True: won; False: lost

    // Constructor:
    public Combat() {
        victory = false;
    }

    // runs combat (level is the difficulty level; 1-5)
    public void run(Player player, Enemy enemy, int level) {
        // Used to read user inputs
        Scanner scanner = new Scanner(System.in);
        boolean playerTurn=true;  // True: player's turn; False: enemy's turn
        boolean playerIsBlocking=false; // True: player is blocking; False: player is not blocking
        int turnCount = 1;   // # of turns the combat has lasted
        int charge = 0;      // charge value; used for player abilities
        int blocksRemaining = player.getNumMaxBlocks();
        // Add user options for charge cost
        chargeOptions.add("Y");
        chargeOptions.add("N");
        // Determines how fast the player must attack (answer correctly) to receive bonus charge
        int diff = 0;
        switch(level) {
            case 1: diff = DIFF_LVL_1; break;
            case 2: diff = DIFF_LVL_2; break;
            case 3: diff = DIFF_LVL_3; break;
            case 4: diff = DIFF_LVL_4; break;
            case 5: diff = DIFF_LVL_5; break;
        }
        // Determines who goes first
        Random random = new Random();
        int randInt = random.nextInt(2);
        if (randInt == 0) {
            playerTurn = false;
        } else if (randInt == 1) {
            playerTurn = true;
        }
        // Announce who goes first
        System.out.println("A coin is tossed...");
        if (playerTurn == true) {
            System.out.println(player.getName() + " goes first!");
        } else {
            System.out.println(enemy.getName() + " goes first!");
        }
        System.out.println();
        // Player and Enemy take turns in combat until one is defeated (currentHP = 0)
        while (player.getCurrentHP() > 0 && enemy.getCurrentHP() > 0) {
            if (playerTurn == true) {    // player's turn
                playerIsBlocking = false;   // reset player's blocking status
                charge += 1;    // charge increased at start of turn
                System.out.println("=== " + player.getName()+ "'s Turn ===");
                System.out.println("Turn: " + turnCount);
                System.out.println("HP: " + player.getCurrentHP()+"/"+player.getMaxHP()); 
                System.out.println("Charge: " + charge); 
                // Options for player on their turn:
                ArrayList<String> playerOptions = new ArrayList<>();
                // Player can choose between attacking and blocking
                System.out.println("Options:");
                System.out.println("  [1]: Attack");
                playerOptions.add("1");
                // The player cannot attempt to block if they have no blocks remaining
                if (blocksRemaining > 0) {
                    System.out.println("  [2]: Block  (Blocks remaining: " + blocksRemaining + ")");
                    playerOptions.add("2");
                }
                System.out.println();
                // Option the player selected
                String userSelection = Main.forceCorrectInput(playerOptions);
                if (userSelection.equals("1")) {         // The user chooses to attack
                    System.out.println("\n" + player.getName() + " goes for an attack!");
                    // Gives user a moment to prepare input
                    System.out.println("(Ready blade)");
                    Main.forceCorrectInput("/");
                    // Run math problem
                    MathFunct.runProblem(player, player.getTimer(), player.getAccuracyTracker());
                    // Retrieve the answer, time, and accuracy
                    int baseDamage = MathFunct.getLastAnswer();    // damage dealt related to answer
                    long timeTaken = player.getTimer().getLastTime();   // time taken affects bonuses
                    boolean problemAccuracy = player.getAccuracyTracker().getLastAccuracy();    // accuracy affects damage
                    // Computes damage to be inflicted to enemy
                    int damageDealt = player.getStrength(); // Player strength always applied
                    damageDealt -= enemy.getDefense();  // Enemy defense always applied against incoming damage
                    // If the problem is answered correctly, deal damage relative to math problem
                    if (problemAccuracy == true) {
                        damageDealt += baseDamage;
                        charge += 1;    // Charge increased on correct answer
                        // If the problem is answered fast enough, gain additional charge
                        if (timeTaken <= diff) {
                            charge += 1;
                            System.out.println("Fast attack!");
                        }
                    } else {
                        charge = 0; // Charge reset on incorrect attack
                        System.out.print("Tempo interrupted! ");
                        System.out.println(player.getName() + " is thown off balance!");
                    }
                    // Allow user to use charge to deal additional damage
                    // if amount is reached
                    if (charge >= CHARGE_COST) {
                        System.out.println("Activate Charge Break?");
                        String chargeOption = Main.forceCorrectInput(chargeOptions);
                        // If user wants to activate charge break, apply bonus damage
                        // and reduce current charge
                        if (chargeOption.equals("Y")) {
                            System.out.println("\n- Charge unleashed! -");
                            charge -= CHARGE_COST;
                            damageDealt += CHARGE_BONUS_DAMAGE;
                            damageDealt += enemy.getDefense();  // charged attack pierces enemy armor
                        }
                    }
                    // Deal damage to enemy
                    enemy.modifyCurrentHP(-damageDealt);
                    // Show user damage dealt
                    System.out.println("\n" + damageDealt + " damage dealt!");
                } else if (userSelection.equals("2")) {  // The user chooses to block
                    System.out.println("\n" + player.getName() + " raises their defenses temporarily against incoming attacks!");
                    playerIsBlocking = true; // set player blocking status to true
                    blocksRemaining -= 1; // reduce blocks left this combat
                    charge += 2; // increase charge
                }
            } else {                    // enemy's turn
                System.out.println("=== " + enemy.getName() + "'s Turn ==="); 
                System.out.println("Turn: " + turnCount);
                System.out.println("HP: " + enemy.getCurrentHP()+"/"+enemy.getMaxHP());   
                
                // Enemy chooses to attack
                System.out.println("\n"+enemy.getName() + " goes for an attack!");
                // Gives user a chance to prepare input
                System.out.println("(Ready blade)");
                Main.forceCorrectInput("/");
                // Run math problem(s)
                for (int i = 0; i < enemy.getNumAttacks(); i++) {
                    MathFunct.runProblem(enemy, player.getTimer(), player.getAccuracyTracker());
                }
                int damageReceived = 0; // damage enemy will deal to player
                // Compute damage dealt
                for (int i = 0; i < enemy.getNumAttacks(); i++) {
                    int timeIndex = player.getTimer().getTimesSize()-(enemy.getNumAttacks()-i);  // index of attack's time in Timer
                    int accuracyIndex = player.getAccuracyTracker().getAccuracySize()-(enemy.getNumAttacks()-i);  // index of attack's accuracy in Timer
                    // If the answer is correct, the user's defense reduces the damage
                    if (player.getAccuracyTracker().getAccuracy(accuracyIndex) == true) {
                        System.out.println("Attack " + (i + 1) + " staggered!");
                        charge += 1; // charge increased on correct answer
                        damageReceived += enemy.getStrength();
                        damageReceived -= player.getDefense();
                        // If the question is answered fast enough, gain bonus charge
                        if (player.getTimer().getTime(timeIndex) <= enemy.getSpeed()) {
                            System.out.println("Quick reaction!");
                            charge += 1; // bonus charge
                        }
                    } else {
                        System.out.println("Attack hits!");
                        damageReceived += enemy.getStrength();
                    }
                }
                // If the player chose to block, reduce damage received additionally
                if (playerIsBlocking) {
                    damageReceived -= (player.getDefense()*enemy.getNumAttacks());
                }                
                // If the damage received would be negative, it is zero
                if (damageReceived < 0) {
                    damageReceived = 0;
                }
                // Show and apply damage dealt by enemy to player
                System.out.println("\n" + damageReceived + " damage dealt!");
                player.modifyCurrentHP(-damageReceived);
            }
            // Switch turns; increase turn count
            turnCount++;
            playerTurn = !playerTurn;
            System.out.println();
        }
        // When combat is finished, determine who one or lost
        // and act accordingly
        if (enemy.getCurrentHP() < 0) {     // enemy lost
            System.out.println("=== You won! === ");
            victory = true; // log player has won the battle
            System.out.println("Winnings:\n");
            System.out.println("Coins: " + enemy.getCoins());
            System.out.println("XP: "  + enemy.getXP());
        } else {        // player lost
            System.out.println("=== Game Over ===");
        }
    }


    public boolean getCombatResult() {return this.victory;}

    
}
