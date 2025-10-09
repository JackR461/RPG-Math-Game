import java.util.ArrayList;

/*
 * -Folders for better organization?
 * -UI
 * -ReadMe
 * -
 */

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Test");
        GenericBossPsychic enemy = new GenericBossPsychic();

        Combat combat = new Combat(player, enemy);

        combat.run();



    }


    // TODO: Introduction/Tutorial/CharacterCreation


}
