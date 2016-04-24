import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class NonogramButton extends JButton implements ActionListener {
    
    private Color c = Color.GRAY; 
    private int timesPressed = 0;
    private boolean isPressed = false;
    private NonogramGame theGame;


    public NonogramButton(NonogramGame g) { 
         this.addActionListener(this);
         theGame = g;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fill3DRect(0,0,getWidth(),getHeight(),true);
    }

    public void reset() {
        if(isPressed){
            timesPressed=1;
            this.doClick();
        }
    }

    public void beenHere() {

        if(timesPressed==2){
            c=Color.GRAY;
            isPressed=false;
            timesPressed=0;
        }

        else if(timesPressed==1) {
           c=Color.BLUE;
           isPressed=true;
        }
    }
    public void actionPerformed(ActionEvent e) { 
        timesPressed += 1;
        beenHere();
    }
}