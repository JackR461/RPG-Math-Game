/*
 * Used to construct the rewards a player gets for leveling up.
 * All boons affect a player, but their benefits vary.
 */

public class Boon {

    // Attributes:
    Player player;  // the player the boon affects

    // Constructor:
    public Boon(Player player) {
        this.player = player;
    }

    // Gives the player a given benefit based on the number entered
    // index range: 0 to 8 (inclusive)
    public void gainBenefit(int i) {
        switch(i) {
            // Increase maximum HP
            case 0: this.player.modifyMaxHP(10); break;
            // Increase current HP to full
            case 1: this.player.setCurrentHP(this.player.getMaxHP()); break;
            // Increase strength
            case 2: this.player.modifyStrength(2); break;
            // Increase defense
            case 3: this.player.modifyDefense(2); break;
            // Increase number of maximum blocks per combat
            case 4: this.player.modifyNumMaxBlocks(2); break;
            // Increase minimum attack number
            case 5: this.player.modifyMinAttackNum(1); break;
            // Increase maximum attack number
            case 6: this.player.modifyMaxAttackNum(1); break;
            // Increase step attack number
            case 7: this.player.modifyStepAttackNum(1); break;
            // Increase number of addends
            case 8: this.player.modifyAddendNum(1); break;
            // If index invalid, do nothing
            default:
            System.out.println("Invalid index");
        }
    }


    // Setters:
    public void setPlayer(Player player) {this.player = player;}
    // Getters:
    public Player getPlayer() {return this.player;}

}
