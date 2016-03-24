import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class KakurasuButton extends JButton implements ActionListener {
    
    private Color c = Color.GRAY; //initial color
    private int timesPressed = 0;
    
    public KakurasuButton(Color c) { 
        this.c=c;
        this.addActionListener(this);
    }
    
    /*  
     * The method paintComponent(Graphics g) is called when
     * java needs to draw the component
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fill3DRect(0,0,getWidth(),getHeight(),true);
        
    }

    public void beenHere() {
        if(timesPressed==3){
            c=Color.GRAY;
            timesPressed=0;
        }
        else if(timesPressed==2) {
            c=Color.WHITE;
            ImageIcon x = new ImageIcon("cancel.gif"); //new icon cross created
            this.setIcon(x); //outputs cross icon on this particular button
        }
        else if(timesPressed==1) {
            c=Color.BLUE;
        }
        else {
            c=Color.GRAY;
        }
    }
    
    public void actionPerformed(ActionEvent e) { //when pressed
        timesPressed += 1;
        beenHere();
    }
    
}