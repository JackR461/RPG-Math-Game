/* 
 * Used to construct a fighter (participates in combat) 
 *  (players and enemies are both extensions of fighter)
 */
public class Fighter {
    // Attributes:
    private String name; // name
    private int level;   // level
    private int XP;      // XP points
    private int coins;   // amount of currency they currently have
    //
    private int maxHP;     // current HP; fluctuates frequently
    private int currentHP; // maximum possible HP
    private int strength;  // attack stat; additional combat power
    private int defense;   // block stat; prevents incoming damage
    //
    private int minAttackNum;  // min# when doing math combat as an attacker
    private int maxAttackNum;  // max# when doing math combat as an attacker
    private int stepAttackNum; // step# when doing math combat as an attacker
    private int addendNum;     // # of #s you add when doing math combat as attacker
    // Starting Attributes: (attributes for starting character)
    //  private final String STARTING_NAME = "TEST";
    private final int STARTING_LEVEL = 1;
    private final int STARTING_XP = 0;
    private final int STARTING_COINS = 10;
    //
    private final int STARTING_MAX_HP = 20;
    private final int STARTING_CURRENT_HP = 20;
    private final int STARTING_STRENGTH = 1;
    private final int STARTING_DEFENSE = 1;
    //
    private final int STARTING_MIN_ATTACK_NUM = 1;
    private final int STARTING_MAX_ATTACK_NUM = 3;
    private final int STARTING_STEP_ATTACK_NUM = 1;
    private final int STARTING_ADDEND_NUM = 2;

    // Base constructor for fighter
    public Fighter(
        String name, int level, int XP, int coins,
        int maxHP, int currentHP, int strength, int defense,
        int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum) 
        {
        this.name = name;
        this.level = level;
        this.XP = XP;
        this.coins = coins;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.strength = strength;
        this.defense = defense;
        this.minAttackNum = minAttackNum;
        this.maxAttackNum = maxAttackNum;
        this.stepAttackNum = stepAttackNum;
        this.addendNum = addendNum;
    }
    // Simple constructor;
    // assumes all stats at starting values
    public Fighter (String name) {
        this.name = name;
        this.level = STARTING_LEVEL;
        this.XP = STARTING_XP;
        this.coins = STARTING_COINS;
        this.maxHP = STARTING_MAX_HP;
        this.currentHP = STARTING_CURRENT_HP;
        this.strength = STARTING_STRENGTH;
        this.defense = STARTING_DEFENSE;
        this.minAttackNum = STARTING_MIN_ATTACK_NUM;
        this.maxAttackNum = STARTING_MAX_ATTACK_NUM;
        this.stepAttackNum = STARTING_STEP_ATTACK_NUM;
        this.addendNum = STARTING_ADDEND_NUM;
    }

    // Setters; generic
    public void setName(String name) {this.name = name;}
    public void setLevel(int level) {this.level = level;}
    public void setXP(int XP) {this.XP = XP;}
    public void setcoins(int coins) {this.coins = coins;}
    public void setMaxHP(int maxHP) {this.maxHP = maxHP;}
    public void setCurrentHP(int currentHP) {this.currentHP = currentHP;}
    public void setStrength(int strength) {this.strength = strength;}
    public void setDefense(int defense) {this.defense = defense;}
    public void setMinAttackNum(int minAttackNum) {this.minAttackNum = minAttackNum;}
    public void setMaxAttackNum (int maxAttackNum) {this.maxAttackNum = maxAttackNum;}
    public void setStepAttackNum(int stepAttackNum) {this.stepAttackNum = stepAttackNum;}
    public void setAddendNum(int addendNum) {this.addendNum = addendNum;}
    // Getters; generic
    public String getName() {return name;}
    public int getLevel() {return level;}
    public int getXP() {return XP;}
    public int getCoins() {return coins;}
    public int getMaxHP() {return maxHP;}
    public int getCurrentHP() {return currentHP;}
    public int getStrength() {return strength;}
    public int getDefense () {return defense;}
    public int getMinAttackNum() {return minAttackNum;}
    public int getMaxAttackNum() {return maxAttackNum;}
    public int getStepAttackNum() {return stepAttackNum;}
    public int getAddendNum() {return addendNum;}

    /* Syntax:
     * Modify: add the number to the number already there
     *  (negative #s decrease, positive #s increase)
     * 
     * 
     */

    // Modifiers (increases/decreases given stat by n)
    public void modifyLevel(int n) {this.level += n;}
    public void modifyXP(int n) {this.XP += n;}
    public void modifyCoins(int n) {this.coins += n;}
    public void modifyMaxHP(int n) {this.maxHP += n;}
    public void modifyCurrentHP(int n) {this.currentHP += n;}
    public void modifyStrength(int n) {this.strength += n;}
    public void modifyDefense(int n) {this.defense += n;}
    public void modifyMinAttackNum(int n) {this.minAttackNum += n;}
    public void modifyMaxAttackNum(int n) {this.maxAttackNum += n;}
    public void modifyStepAttackNum(int n) {this.stepAttackNum += n;}
    public void modifyStepAddendNum(int n) {this.addendNum += n;}



}
