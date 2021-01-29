/**
 * 
 */
package se.mns;

/**
 * @author Mårten Hernebring
 * @version 1
 *
 */

import javax.swing.JFrame;

public class Main {

    /**
     * @param args not used
     */
    public static void main(String[] args) {
        JFrame main = new JFrame("Error message");

        CustomerInteraction ci = new CustomerInteraction();

        main.setSize(400, 400);
        main.setResizable(false);
        main.add(ci);
        main.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

}
