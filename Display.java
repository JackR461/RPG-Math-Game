import javax.swing.*;
import java.awt.*;

/*
 * Display used to take user inputs
 * and show combats/events
 * 
 */

public class Display extends JPanel {
    
    // Attributes:
    String userInput;   // Used to record what the user's input is

    public Display() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //  g.drawString("Test", 50, 50);

        JTextField textField = new JTextField(15);


    }

    public void start() {
        JFrame frame = new JFrame("Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new Display());
        frame.setVisible(true);
    }
    
}
