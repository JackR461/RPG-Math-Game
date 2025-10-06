/*
 * -How make 'beastiary'? (list of premade enemies/boons to then pick one from)
 *      -files to sort?
 * -UI
 * -ReadMe
 * -
 */

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Test");
        Enemy enemy = new Enemy("Enemy", 2, 2);

        Combat combat = new Combat(player, enemy);
        combat.run();


    }


    // TODO: Introduction/Tutorial/CharacterCreation


}
