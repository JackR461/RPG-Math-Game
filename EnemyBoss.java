
/*
 * Used to construct boss enemies
 */


public abstract class EnemyBoss extends Enemy {

    // Constructor:
    public EnemyBoss(
        String name, int level, int XP,
        int maxHP, int currentHP, int strength, int defense,
        int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
        int numAttacks, int speed) 
        {
        super(name, level, XP, 
            maxHP, currentHP, strength, defense, 
            minAttackNum, maxAttackNum, stepAttackNum, addendNum, numAttacks, speed);
        }
    // Simple constructor:
    public EnemyBoss(String name, int numAttacks, int speed) {
        super(name, numAttacks, speed);
    }

    //
    public abstract void specialAbility();
    
}