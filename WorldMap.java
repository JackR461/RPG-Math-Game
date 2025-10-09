import java.util.ArrayList;
import java.util.Random;
/* Using Random:
 *   Random random = new Random();
 *   int randInt = random.nextInt(2);   //generates random number of 1 or 0
 */

 /*
 * Used to construct the world the player character campaigns through.
 * Randomly fills the world with events or enemies.
 * Has a boss fight at the very end after a select distance
 */

public class WorldMap {
    
    // Attributes:
    private int totalCombats; // The total # of fights a player will experience before a boss fight
    private int combatsPerRest; // Used to track how many combats a player must face before a rest stop
    private int coveredCombats; // Used to track how many combats the player has experienced so far
    private ArrayList<Enemy> enemyEncounters; // List of potential enemies a user will encounter
    private Boons boons;
    private EnemyBoss bbeg; // The boss the player must fight at the end 

    private final int DEFAULT_TOTAL_COMBAT_NUM = 4; // default number of combats is 4
    private final int DEFAULT_TOTAL_COMBATS_PER_REST = 3; // normally, for every 3 fights, there is 1 rest
    private final int REST_HEAL = 5;    // amount a player will heal at a rest site

    // Constructor:
    public WorldMap (int totalCombats, int combatsPerRest, ArrayList<Enemy> enemyEncounters, Boons boons, EnemyBoss bbeg) {
        this.totalCombats = totalCombats;
        this.combatsPerRest = combatsPerRest;
        this.coveredCombats = 0;    // starts at no combats covered
        this.enemyEncounters = enemyEncounters;
        this.boons = boons;
        this.bbeg = bbeg;
    }
    // With no specific combat number or combats per rest, assume default
    public WorldMap(ArrayList<Enemy> enemyEncounters, Boons boons, EnemyBoss bbeg) {
        this.totalCombats = DEFAULT_TOTAL_COMBAT_NUM;
        this.combatsPerRest = DEFAULT_TOTAL_COMBATS_PER_REST;
        this.coveredCombats = 0;
        this.enemyEncounters = enemyEncounters;
        this.boons = boons;
        this.bbeg = bbeg;
    }

    // Allows user to play through a given world
    public void play(Player player) {
        // While player has not lost, there are still enemies to fight, and there should still be another combat,
        // run through world
        while (player.getCurrentHP() > 0 && (enemyEncounters.size() != 0) && coveredCombats < totalCombats) {
            // Player goes through a number of combats
            // based on combats per rest
            for (int i = 0; i < combatsPerRest; i++) {
                // Select random enemy to fight player
                Random random = new Random();
                int randomEnemyIndex = random.nextInt(enemyEncounters.size());
                Enemy randomEnemy = enemyEncounters.get(randomEnemyIndex);
                // Remove from potential list
                enemyEncounters.remove(randomEnemyIndex);
                // Generate combat
                Combat combat = new Combat(player, randomEnemy);
                combat.run();
                // Increase combats covered
                this.coveredCombats++;
                // If player has won, check if they have enough xp for a level up
                if (combat.getCombatResult() == true) {
                    // If they have enough XP, level up
                    if (player.getXP() >= player.getXPForLevelUp()) {
                        player.modifyXP(-player.getXPForLevelUp());
                        player.modifyLevel(1);
                        System.out.println("Level up!");
                        System.out.println("Current level: " + player.getLevel());
                        player.modifyXPForLevelUp(player.getXPForLevelUp()); // XP requirement doubled                 
                        // TODO: The player chooses between one of three boons
                    
                    
                    }
                } else {
                    // If they have lost, exit loop
                    return;
                }
                // If enough combats are completed, the player rests
                // (heals HP at a campfire)
                if (coveredCombats % combatsPerRest == 0) {
                    System.out.println("Seeing night fall, you rest");
                    player.modifyCurrentHP(5);
                    System.out.println(REST_HEAL + " HP recovered!");
                    System.out.println("Curren HP: " + player.getCurrentHP());
                }
            }
            
            // TODO: done generic combats -> random boss


            
        }


    }


    // Setters:
    public void setTotalCombats(int totalCombats) {this.totalCombats = totalCombats;}
    public void setCombatsPerRest (int combatsPerRest) {this.combatsPerRest = combatsPerRest;}
    public void setCoveredCombats (int coveredCombats) {this.coveredCombats = coveredCombats;}
    public void setEnemyEncounters (ArrayList<Enemy> enemyEncounters) {this.enemyEncounters = enemyEncounters;}
    public void setBoons (Boons boons) {this.boons = boons;}
    public void setBbeg (EnemyBoss bbeg) {this.bbeg = bbeg;}
    // Getters:
    public int getTotalCombats () {return this.totalCombats;}
    public int getCombatsPerRest () {return combatsPerRest;}
    public int getCoveredCombats () {return coveredCombats;}
    public ArrayList<Enemy> getEnemyEncounters () {return enemyEncounters;}
    public Boons boons () {return this.boons;}
    public EnemyBoss getBbeg () {return this.bbeg;}

    



}
