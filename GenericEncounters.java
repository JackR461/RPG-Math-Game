import java.util.ArrayList;

/*
 * Generic list of enemies a player will face
 */

// Regular enemies
public class GenericEncounters {
    
    private final int NUM_TOTAL_ENEMIES = 6;

    // Generates list of regular enemies a player will face
    // on the WorldMap
    /*
     * Attribute format:
     * String name, int level, int XP,
     *  int maxHP, int currentHP, int strength, int defense,
     *  int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
     *  int numAttacks, int speed
     */
    public static ArrayList<Enemy> generateEnemyList() {
    ArrayList<Enemy> genericEnemyEncounters = new ArrayList<>();
        Enemy enemy1 = new Enemy
                            ("Swordsperson", 1, 15, 
                            30, 30, 4, 2, 
                            1, 5, 1, 3, 
                            2, 2);
        genericEnemyEncounters.add(enemy1);
        Enemy enemy2 = new Enemy
                            ("Shieldsperson", 1, 15,
                            25, 25, 4, 8,
                            0, 50, 5, 2, 
                            1, 3);
        genericEnemyEncounters.add(enemy2);
        Enemy enemy3 = new Enemy
                            ("Robot", 1, 15,
                            20, 20, 4, 5, 
                            0, 1, 1, 8,
                            1, 2);
        genericEnemyEncounters.add(enemy3);
        Enemy enemy4 = new Enemy
                            ("Triangle Wielder", 1, 15,
                            33, 33, 3, 0, 
                            3, 9, 3, 3,
                            3, 3);
        genericEnemyEncounters.add(enemy4);
        Enemy enemy5 = new Enemy
                            ("Giant", 1, 15,
                            50, 50, 5, 0, 
                            10, 30, 1, 2,
                            1, 5);
        genericEnemyEncounters.add(enemy5);
        Enemy enemy6 = new Enemy
                            ("Archer", 1, 15,
                            40, 40, 3, 2, 
                            0, 8, 2, 2,
                            4, 2);
        genericEnemyEncounters.add(enemy6);
        // Returns list of enemies
        return genericEnemyEncounters;
    }

}
