/**
 * 
 */
package se.mns;

/**
 * @author Mårten Hernebring
 * @version 2
 *
 */

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        //Eclipse run conf: 123 mail@test.com 031-288339
        ContactBook contacts = new ContactBook();
        var customerInteraction = new CustomerInteraction();
        try {
            Contact contact = new Contact(args[0], args[1], args[2]);
            contacts.add(contact);
            customerInteraction.setMessage("Lagt till kontakten.");
        } catch (IllegalArgumentException ex) {
            //error will show on default
        }
        showMessage(customerInteraction);
    }

    private static void showMessage(CustomerInteraction customerInteraction) {
        JFrame main = new JFrame("Kontaktbok");
        main.setSize(800, 800);
        main.setResizable(false);
        main.add(customerInteraction);
        main.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

}
