import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class KakurasuButton extends JButton implements ActionListener {
    
    private Color c = Color.GRAY; //initial color
    
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
        c = Color.BLUE; //color turns to blue when pressed
    }
    
    public void actionPerformed(ActionEvent e) { //when pressed
        beenHere();
    }
    
}