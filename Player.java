
public class Player extends Fighter {

    // Attributes:
    private Timer timer;                // Used to track times across all problems
    private AccuracyTracker accuracy;   // Used to track accuracy across all problems
    private int numMaxBlocks;           // # of times a Player can block each combat
    //
    private final int STARTING_NUM_MAX_BLOCKS = 3;

    // Constructor: (through parent constructor)
     public Player (
        String name, int level, int XP, int coins,
        int maxHP, int currentHP, int strength, int defense, int numMaxBlocks,
        int minAttackNum, int maxAttackNum, int stepAttackNum, int addendNum) 
        {
        super(name, level, XP, coins, 
            maxHP, currentHP, strength, defense, 
            minAttackNum, maxAttackNum, stepAttackNum, addendNum);
        this.timer = new Timer();
        this.accuracy = new AccuracyTracker();
        this.numMaxBlocks = numMaxBlocks;
    }
    // Simple constructor: (through parent constructor)
    public Player(String name) {
        super(name);
        timer = new Timer();
        accuracy = new AccuracyTracker();
        this.numMaxBlocks = STARTING_NUM_MAX_BLOCKS;
    }

    // Getters:
    public Timer getTimer() {return timer;}
    public AccuracyTracker getAccuracyTracker() {return accuracy;}
    public int getNumMaxBlocks() {return numMaxBlocks;}
    // Setters:
    public void setNumMaxBlocks(int numMaxBlocks) {this.numMaxBlocks = numMaxBlocks;}

}