/*
 * Assignment 6
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * class
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
public class SwingLoginExample {
    
    public static void main(String[] args) {    
        // create JFrame entity
        JFrame frame = new JFrame("Assignment_6");
        // Setting the width and height of frame
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel();    
        frame.add(panel);
        graphical_interface.placeComponents(panel);        
        frame.setVisible(true);
    }


}