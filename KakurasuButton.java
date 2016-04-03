import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class KakurasuButton extends JButton implements ActionListener {
    
    private Color c = Color.GRAY; 
    private int timesPressed = 0;
    private int buttonNumber;
    private KakurasuFrame theFrame;
    private KakurasuGame theGame;
    private int valueDown;
    private int valueAcross;

    public KakurasuButton(Color c, int i, KakurasuFrame f, KakurasuGame g) { 
        this.c=c;
        this.addActionListener(this);
        this.buttonNumber = i;
        theFrame = f;
        theGame = g;
        valueDown = g.setValueDown(i);
        valueAcross = g.setValueAcross(i);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fill3DRect(0,0,getWidth(),getHeight(),true);
    }

    public void beenHere(KakurasuButton b) {
        if(timesPressed==3){
            c=Color.GRAY;
            timesPressed=0;
            System.out.println("Back to normal :(");
            theFrame.setMessageAcross(buttonNumber, "");
            theFrame.setMessageDown(buttonNumber, "");
        }
        else if(timesPressed==2) {
            c=Color.WHITE;
            ImageIcon x = new ImageIcon("cancel.gif"); 
            this.setIcon(x); 
            System.out.println("Pause");
            theFrame.setMessageAcross(buttonNumber, "");
            theFrame.setMessageDown(buttonNumber, "");

        }
        else if(timesPressed==1) {
            c=Color.BLUE;
            System.out.println("Hey");
            theGame.pressedTrue(buttonNumber);
            theFrame.setMessageAcross(buttonNumber, "(" + String.valueOf(valueAcross) + ")");
            theFrame.setMessageDown(buttonNumber, "(" + String.valueOf(valueDown) + ")");
            //b.addActionListener(oneHand);
        }
        else {
            c=Color.GRAY;
        }
    }

    public void valueAssign() {
        
    }
    
    public void actionPerformed(ActionEvent e) { 
        timesPressed += 1;
        beenHere(this);
    }
}