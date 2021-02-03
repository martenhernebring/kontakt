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
    private JPanel contact = new JPanel();

    private JButton addButton = new JButton("Lägg till");
    private JButton removeButton = new JButton("Ta bort");
    private JButton searchButton = new JButton("Sök");
    private JButton quitButton = new JButton("Avsluta");
    private JPanel buttons = new JPanel();

    private ContactBook contacts = new ContactBook();

    public GraphicalUserInterface() {
        setLayout(new GridLayout(2, 1)); // 2 rader 1 kolumner
        add(contact); // översta
        add(buttons); // understa

        // övre halvan
        contact.setLayout(new GridLayout(3, 2)); // 3 r 2 k
        contact.add(nameLabel);
        contact.add(nameText);
        contact.add(emailLabel);
        contact.add(emailText);
        contact.add(telephoneLabel);
        contact.add(telephoneText);

        // undre halvan
        buttons.add(searchButton);
        buttons.add(addButton);
        buttons.add(removeButton);
        buttons.add(quitButton);

        getContentPane().setBackground(Color.white);

        pack();

        nameText.addActionListener(this);
        emailText.addActionListener(this);
        telephoneText.addActionListener(this);

        quitButton.addActionListener(this);
        addButton.setEnabled(true);
        removeButton.setEnabled(false);
        searchButton.setEnabled(false);
        quitButton.setEnabled(true);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitButton) {
            System.exit(0);
        } else if (e.getSource() == addButton) {
            Scanner scan = new Scanner(nameText.getText());
            String name = scan.nextLine();
            scan.close();
            scan = new Scanner(emailText.getText());
            String email = scan.nextLine();
            scan.close();
            scan = new Scanner(telephoneText.getText());
            String phone = scan.nextLine();
            Contact contact = null;
            try {
                contact = new Contact(name, email, phone);
                contacts.add(contact);
                scan.close();
                System.out.println("Lagt till kontakten.");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

}
