import java.util.ArrayList;

/*
 * Generic list of enemies a player will face
 */

// Regular enemies
public class GenericEncounters {
    
    // Generates list of regular enemies a player will face
    // on the WorldMap
    /*
     * Attribute format:
     * String name, int level, int XP,
     *  int maxHP, int currentHP, int strength, int defense,
     *  int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
     *  int numAttacks, int speed
     */
    public ArrayList<Enemy> generateEnemyList() {
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
        // Returns list of enemies
        return genericEnemyEncounters;
    }

    // Generates list of potential boss enemies a player may experience
    // on the WorldMap.
    // A player will only face one of the bosses (random) in a given playthrough
    public ArrayList<EnemyBoss> generateEnemyBossList() {
        ArrayList<EnemyBoss> genericEnemyBosses = new ArrayList<>();
        
        EnemyBoss boss1 = new EnemyBoss("", 0, 0, 
                                        0, 0, 0, 0, 
                                        0, 0, 0, 0, 
                                        0, 0) { 
        };


        return genericEnemyBosses;
    }

}
