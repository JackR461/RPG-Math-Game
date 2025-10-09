public class GenericBossPsychic extends EnemyBoss {
    
    /*
     * Attribute format:
     * String name, int level, int XP,
     *  int maxHP, int currentHP, int strength, int defense,
     *  int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
     *  int numAttacks, int speed
     *  String abilityDesc
     */

    public GenericBossPsychic () {
        super("Psychic", 3, 100, 
            60, 60, 4, 0, 
            0, 6, 2, 4, 
            3, 1,
            "Psychic powers drain your defense!");
    }

    // Special ability removes defense from player
    public void specialAbility(Player player) {
        player.modifyDefense(-1);
    }

}
