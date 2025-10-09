
/*
 * Used to construct boss enemies
 */


public abstract class EnemyBoss extends Enemy {

    // Attributes:
    private String abilityDesc; // String used to describe special ability

    // Constructor:
    public EnemyBoss(
        String name, int level, int XP,
        int maxHP, int currentHP, int strength, int defense,
        int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
        int numAttacks, int speed, 
        String abilityDesc) 
        {
        super(name, level, XP, 
            maxHP, currentHP, strength, defense, 
            minAttackNum, maxAttackNum, stepAttackNum, addendNum, numAttacks, speed);
            this.abilityDesc = abilityDesc;
        }
    // Simple constructor:
    public EnemyBoss(String name, int numAttacks, int speed, String abilityDesc) {
        super(name, numAttacks, speed);
        this.abilityDesc = abilityDesc;
    }

    // All bosses have a unique special ability
    // that is used in addition to attacking every turn
    public void specialAbility(Player player) {}
    
    // Setters:
    public void setAbilityDesc(String abilityDesc) {this.abilityDesc = abilityDesc;}
    // Getters:
    public String getAbilityDesc() {return this.abilityDesc;}


    
    
}