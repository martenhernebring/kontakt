/**
 * 
 */
package se.mns;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/*Will be used for animations
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;*/

import javax.swing.JPanel;

public class CustomerInteraction extends JPanel {
    private static final long serialVersionUID = -783845033008947920L;
    
    private boolean error = true;
    private String message = "Error!";

    public void setMessage(String message) {
        this.error = false;
        this.message = message;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint(g);
    }

    private void repaint(Graphics g) {
        final Dimension d = this.getSize();
        if(error) {
            g.setColor(Color.red);
            g.fillRect(0, 0, d.width, d.height);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString(message, 20, d.width / 2 - 24);
        } else {
            g.setColor(Color.green);
            g.fillRect(0, 0, d.width, d.height);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString(message, 20, d.width / 2 - 24);
        }
    }

}
