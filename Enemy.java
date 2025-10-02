import java.util.ArrayList;

/*
 * Used to construct an enemy (opponent to the player in combat).
 * When an enemy attacks, a player must dodge the attack.
 * When an enemy is defeated, its XP and coins are transfered to the Player
 */

public class Enemy extends Fighter{
    // Attributes:
    private int numAttacks; // number of times the enemy attacks
    private int speed;      // attack speed (number used when a player defends)

    // Constructor: (through parent constructor)
     public Enemy (
        String name, int level, int XP, int coins,
        int maxHP, int currentHP, int strength, int defense,
        int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum,
        int numAttacks, int speed) 
        {
        super(name, level, XP, coins, 
            maxHP, currentHP, strength, defense, 
            minAttackNum, maxAttackNum, stepAttackNum, addendNum);
            this.numAttacks = numAttacks;
            this.speed = speed;
    }
    // Simple constructor: (through parent constructor)
    public Enemy(String name, int numAttacks, int speed) 
        {
        super(name);
        }

    // Setters:
    public void setNumAttacks(int numAttacks) {this.numAttacks = numAttacks;}
    public void setSpeed(int speed) {this.speed = speed;}
    // Getters:
    public int getNumAttacks() {return numAttacks;}
    public int getSpeed() {return speed;}
    // Modifiers:
    public void modifyAttackNum(int n) {
        // attackNum cannot be less than 1
        if (numAttacks - n < 1) {
            this.numAttacks = 1;
        } else {
            this.numAttacks -= n;
        }
    }
    public void modifySpeed(int n) {this.speed -= n;}



}
