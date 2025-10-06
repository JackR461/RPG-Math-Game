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
    private ArrayList<Boon> boons;
    private EnemyBoss bbeg; // The boss the player must fight at the end 

    private final int DEFAULT_TOTAL_COMBAT_NUM = 4; // normally, the total number of enemy fights is 6
    private final int DEFAULT_TOTAL_COMBATS_PER_REST = 2; // normally, for every 3 fights, there is 1 rest

    // Constructor:
    public WorldMap (int totalCombats, int combatsPerRest, ArrayList<Enemy> enemyEncounters, ArrayList<Boon> boons, EnemyBoss bbeg) {
        this.totalCombats = totalCombats;
        this.combatsPerRest = combatsPerRest;
        this.coveredCombats = 0;
        this.enemyEncounters = enemyEncounters;
        this.boons = boons;
        this.bbeg = bbeg;
    }
    // With no specific combat number or combats per rest, assume default
    public WorldMap(ArrayList<Enemy> enemyEncounters, ArrayList<Boon> boons, EnemyBoss bbeg) {
        this.totalCombats = DEFAULT_TOTAL_COMBAT_NUM;
        this.combatsPerRest = DEFAULT_TOTAL_COMBATS_PER_REST;
        this.coveredCombats = 0;
        this.enemyEncounters = enemyEncounters;
        this.boons = boons;
        this.bbeg = bbeg;
    }

    // Setters:
    public void setTotalCombats(int totalCombats) {this.totalCombats = totalCombats;}
    public void setCombatsPerRest (int combatsPerRest) {this.combatsPerRest = combatsPerRest;}
    public void setCoveredCombats (int coveredCombats) {this.coveredCombats = coveredCombats;}
    public void setEnemyEncounters (ArrayList<Enemy> enemyEncounters) {this.enemyEncounters = enemyEncounters;}
    public void setBoons (ArrayList<Boon> boons) {this.boons = boons;}
    public void setBbeg (EnemyBoss bbeg) {this.bbeg = bbeg;}
    // Getters:
    public int getTotalCombats () {return this.totalCombats;}
    public int getCombatsPerRest () {return combatsPerRest;}
    public int getCoveredCombats () {return coveredCombats;}
    public ArrayList<Enemy> getEnemyEncounters () {return enemyEncounters;}
    public ArrayList<Boon> boons () {return this.boons;}
    public EnemyBoss getBbeg () {return this.bbeg;}

    
}
