import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Clock extends JPanel {

    int counter;


    public Clock () {
        this.setPreferredSize(new Dimension(50,50));
    }

    public void bumpCount() {
        counter++;
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.orange);
        g.setFont(new Font("Serif",Font.BOLD,10));

        String counterS = ""+counter;
        
        g.drawString(counterS, 10, 50);


    }

}