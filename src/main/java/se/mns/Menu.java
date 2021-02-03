/**
 * 
 */
package se.mns;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Mårten Hernebring
 * @version 1
 *
 */
public class Menu extends JFrame implements ActionListener {

    private JButton addButton = new JButton("Lägg till");
    private JButton removeButton = new JButton("Ta bort");
    private JButton searchButton = new JButton("Sök");
    private JButton quitButton = new JButton("Avsluta");

    /**
     * Required by Eclipse
     */
    private static final long serialVersionUID = -732393840433299028L;

    public Menu() {
        setLayout(new GridLayout(2,2));
        add(addButton);
        add(removeButton);
        add(searchButton);
        add(quitButton);
        getContentPane().setBackground(Color.white);
        quitButton.addActionListener(this);
        addButton.setEnabled(false);
        removeButton.setEnabled(false);
        searchButton.setEnabled(false);
        quitButton.setEnabled(true);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //knapplyssnare
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quitButton) {
            System.exit(0);
        }
    }

}
