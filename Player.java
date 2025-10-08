
public class Player extends Fighter {

    // Attributes:
    private Timer timer;                // Used to track times across all problems
    private AccuracyTracker accuracy;   // Used to track accuracy across all problems
    private int numMaxBlocks;           // # of times a Player can block each combat
    private int xpForLevelUp;           // XP needed for next level up
    //
    private final int STARTING_NUM_MAX_BLOCKS = 3;  // Maximum number of blocks a player is allowed in a combat
    private final int STARTING_XP_FOR_LEVEL_UP = 20; // starting XP Requirement for next level up

    // Constructor: (through parent constructor)
     public Player (
        String name, int level, int XP, int xpForLevelUp,
        int maxHP, int currentHP, int strength, int defense, int numMaxBlocks,
        int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum) 
        {
        super(name, level, XP,
            maxHP, currentHP, strength, defense, 
            minAttackNum, maxAttackNum, stepAttackNum, addendNum);
        this.timer = new Timer();
        this.accuracy = new AccuracyTracker();
        this.xpForLevelUp = xpForLevelUp;
        this.numMaxBlocks = numMaxBlocks;
    }
    // Simple constructor: (through parent constructor)
    public Player(String name) {
        super(name);
        timer = new Timer();
        accuracy = new AccuracyTracker();
        this.xpForLevelUp = STARTING_XP_FOR_LEVEL_UP;
        this.numMaxBlocks = STARTING_NUM_MAX_BLOCKS;
    }

    // Getters:
    public Timer getTimer() {return timer;}
    public AccuracyTracker getAccuracyTracker() {return accuracy;}
    public int getNumMaxBlocks() {return numMaxBlocks;}
    public int getXPForLevelUp() {return this.xpForLevelUp;}
    // Setters:
    public void setNumMaxBlocks(int numMaxBlocks) {this.numMaxBlocks = numMaxBlocks;}
    public void setXPForLevelUp(int xpForLevelUp) {this.xpForLevelUp = xpForLevelUp;}
    // Modifiers:
    public void modifyNumMaxBlocks (int n) {this.numMaxBlocks += n;}
    public void modifyXPForLevelUp (int n) {this.xpForLevelUp += n;}

}