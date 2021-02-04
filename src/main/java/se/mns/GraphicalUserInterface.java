package se.mns;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/** Creates a GUI with name, email and phone fields, 4 buttons, 3 static and 2 dynamics labels
 * @author Mårten Hernebring
 * @version 3
 */
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

  private JButton addButton = new JButton("Lägg till");
  private JButton removeButton = new JButton("Ta bort");
  private JButton searchButton = new JButton("Sök");
  private JButton quitButton = new JButton("Avsluta");

  private ContactBook contacts = new ContactBook();
  private String name = "";

  private JLabel message = new JLabel("");
  private JLabel error = new JLabel("");

  /**Creates 6 x 2 grid with fields, buttons and dynamic labels */
  public GraphicalUserInterface() {
    setLayout(new GridLayout(6, 2));

    //3 x 2 contact data
    add(nameLabel);
    add(nameText);
    add(emailLabel);
    add(emailText);
    add(telephoneLabel);
    add(telephoneText);

    //2 x 2 GUI buttons
    add(searchButton);
    add(addButton);
    add(removeButton);
    add(quitButton);

    //1 x 2 event labels
    add(message);
    add(error);

    getContentPane().setBackground(Color.white);

    Font font = new Font("SansSerif", Font.BOLD, 16);
    nameLabel.setFont(font);
    nameText.setFont(font);
    emailLabel.setFont(font);
    emailText.setFont(font);
    telephoneLabel.setFont(font);
    telephoneText.setFont(font);
    addButton.setFont(font);
    removeButton.setFont(font);
    searchButton.setFont(font);
    quitButton.setFont(font);
    message.setFont(font);
    error.setFont(font);

    //Required by AssertJSwingJUnitTestCase in TestGUI
    nameText.setName("nameText");
    addButton.setName("addButton");
    error.setName("error");

    setSize(800, 400);

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

  /**If user clicks quit, add, remove or search this method will be called
   * @param e Trigged by a user or artificial button-click in GUI
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == quitButton) {
      System.out.println(e);
      System.exit(0);
    } else if (e.getSource() == addButton) {
      scanName();
      Scanner scan = new Scanner(emailText.getText());
      String email = "";
      if (scan.hasNextLine()) {
        email = scan.nextLine();
      }
      scan.close();
      emailText.setText("");
      scan = new Scanner(telephoneText.getText());
      String phone = "";
      if (scan.hasNextLine()) {
        phone = scan.nextLine();
      }
      scan.close();
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
      if (contacts.contains(name)) {
        message.setText("Kontakt tillagd");
      } else {
        message.setText("Kontakten finns ej");
      }
    }
  }

  private void scanName() {
    Scanner scan = new Scanner(nameText.getText());
    if (scan.hasNextLine()) {
      name = scan.nextLine();
    }
    scan.close();
    nameText.setText("");
  }

}
