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
    private int totalEvents; // The total # of fights/events a player will experience before a boss fight
    private int coveredCombats; // Used to track how many combats the player has experienced so far
    private ArrayList<Enemy> enemyEncounters; // List of potential enemies a user will encounter

    
}
