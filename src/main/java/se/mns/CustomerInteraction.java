/**
 * 
 */
package se.mns;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Mårten Hernebring
 * @version 1
 *
 */
public class CustomerInteraction extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint(g);
    }

    /**
     * Call this method when the graphics needs to be repainted on the graphics
     * surface. Simple version just displays error message
     * 
     * @param g the graphics to paint on
     */
    private void repaint(Graphics g) {
        final Dimension d = this.getSize();
        g.setColor(Color.red);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("Error!", 20, d.width / 2 - 24);
    }

}
