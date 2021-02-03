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


    /**
     * Required by Eclipse
     */
    private static final long serialVersionUID = -732393840433299028L;

    public Menu() {
        setLayout(new GridLayout(1,1));
        JButton addButton = new JButton("Lägg till");
        add(addButton);
        getContentPane().setBackground(Color.white);
        addButton.addActionListener(this);
        addButton.setEnabled(false);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //knapplyssnare
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }

}
