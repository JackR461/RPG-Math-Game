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
        GenericBossPsychic psychic = new GenericBossPsychic();

        Combat combat = new Combat(player, psychic);

        combat.run();



    }


    // TODO: Introduction/Tutorial/CharacterCreation


}
