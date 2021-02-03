package se.mns;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicalUserInterface extends JFrame implements ActionListener {

    /**
     * Required by Eclipse
     */
    private static final long serialVersionUID = -8540673446737735816L;
    private JTextField nameText = new JTextField(30);
    private JTextField emailText = new JTextField(30);
    private JTextField telephoneText = new JTextField(30);
    private JLabel nameLabel = new JLabel("För och efternamn:", JLabel.RIGHT);
    private JLabel emailLabel = new JLabel("Email (med @):", JLabel.RIGHT);
    private JLabel telephoneLabel = new JLabel("Telefon:", JLabel.RIGHT);
    //private JPanel contact = new JPanel();

    private JButton addButton = new JButton("Lägg till");
    private JButton removeButton = new JButton("Ta bort");
    private JButton searchButton = new JButton("Sök");
    private JButton quitButton = new JButton("Avsluta");
    //private JPanel buttons = new JPanel();

    private ContactBook contacts = new ContactBook();
    private String name = "";
    
    private JLabel message = new JLabel("");
    private JLabel error = new JLabel("");
    //private JPanel interaction = new JPanel();

    public GraphicalUserInterface() {
        setLayout(new GridLayout(6, 2)); // 3 rader 1 kolumner
        //add(contact); // översta
        //add(buttons); // mellersta
        //add(interaction); //understa

        // översta
        //contact.setLayout(new GridLayout(3, 2)); // 3 r 2 k
        add(nameLabel);
        add(nameText);
        add(emailLabel);
        add(emailText);
        add(telephoneLabel);
        add(telephoneText);

        // mellersta
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(quitButton);
        
        //understa
        add(message);
        add(error);

        getContentPane().setBackground(Color.white);

        pack();

        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        searchButton.addActionListener(this);
        quitButton.addActionListener(this);
        
        addButton.setEnabled(true);
        removeButton.setEnabled(true);
        searchButton.setEnabled(true);
        quitButton.setEnabled(true);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitButton) {
            System.exit(0);
        } else if (e.getSource() == addButton) {
            scanName();
            Scanner scan = new Scanner(emailText.getText());
            String email = scan.nextLine();
            scan.close();
            emailText.setText("");
            scan = new Scanner(telephoneText.getText());
            String phone = scan.nextLine();
            telephoneText.setText("");
            Contact contact = null;
            try {
                contact = new Contact(name, email, phone);
                contacts.add(contact);
                scan.close();
                message.setText("Lagt till kontakten.");
            } catch (IllegalArgumentException ex) {
                error.setText(ex.getMessage());
            }
        } else if (e.getSource() == removeButton) {
            scanName();
            contacts.remove(name);
            message.setText("Kontakten borttagen");
        } else if (e.getSource() == searchButton) {
            scanName();
            if(contacts.contains(name)) {
                message.setText("Kontakt tillagd");
            } else {
                message.setText("Kontakten finns ej");
            }
        }

    }
    
    private void scanName() {
        Scanner scan = new Scanner(nameText.getText());
        name = scan.nextLine();
        scan.close();
        nameText.setText("");
    }

}
