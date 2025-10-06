/*
 * Used to construct the rewards a player gets for leveling up.
 * All boons affect a player, but their benefits vary.
 */

public abstract class Boon {

    // Attributes:
    Player player;  // the player the boon affects

    // Constructor:
    public Boon(Player player) {
        this.player = player;
    }

    //
    public abstract void boonBenefit();

    // Setters:
    public void setPlayer(Player player) {this.player = player;}
    // Getters:
    public Player getPlayer() {return this.player;}

}
