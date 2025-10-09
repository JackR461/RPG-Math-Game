public class GenericBossGhost extends EnemyBoss {
 
    /*
     * Attribute format:
     * String name, int level, int XP,
     *  int maxHP, int currentHP, int strength, int defense,
     *  int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
     *  int numAttacks, int speed
     *  String abilityDesc
     */

    public GenericBossGhost () {
        super("Ghost", 3, 100, 
            50, 50, 4, 99, 
            0, 10, 1, 3, 
            3, 2,
            "A chill in the air drains your HP!");
    }

    // Special ability removes health from player
    public void specialAbility(Player player) {
        player.modifyCurrentHP(-1);
        this.modifyCurrentHP(1);
    }

    
}
