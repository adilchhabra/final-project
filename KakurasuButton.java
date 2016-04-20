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
    private boolean pressed = false;
    private boolean isSolved = false;

    public KakurasuButton(Color c, int i, KakurasuFrame f, KakurasuGame g) { 
        this.c=c;
        this.addActionListener(this);
        this.buttonNumber = i;
        theFrame = f;
        theGame = g;      
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fill3DRect(0,0,getWidth(),getHeight(),true);
    }

    public void beenHere(KakurasuButton b) {

        if(timesPressed==3){
            c=Color.GRAY;
            this.setIcon(null);
            timesPressed=0;
            valueAcross = theGame.getAcross(buttonNumber);
            valueDown = theGame.getDown(buttonNumber);
            if(theGame.rowComplete(buttonNumber)) {
            	theFrame.setMessageAcross(buttonNumber, "✓");
            }
            else{
                theFrame.setMessageAcross(buttonNumber, "(" + String.valueOf(valueAcross) + ")");
            }
            if(theGame.colComplete(buttonNumber)) {
            	theFrame.setMessageDown(buttonNumber, "✓");
            }
            else {
            	theFrame.setMessageDown(buttonNumber, "(" + String.valueOf(valueDown) + ")");
            }   
            
            if(valueAcross==0) 
            	theFrame.setMessageAcross(buttonNumber, "");
            if(valueDown==0)
            	theFrame.setMessageDown(buttonNumber,"");
        }

        else if(timesPressed==2) {
            c=Color.WHITE;
            ImageIcon x = new ImageIcon("cancel.gif"); 
            this.setIcon(x);
            //theFrame.repaint(); 
            valueAcross = theGame.setAcrossEmpty(buttonNumber);
            valueDown = theGame.setDownEmpty(buttonNumber);
            if(theGame.rowComplete(buttonNumber)) {
            	theFrame.setMessageAcross(buttonNumber, "✓");
            }
            else{
                theFrame.setMessageAcross(buttonNumber, "(" + String.valueOf(valueAcross) + ")");
            }
            if(theGame.colComplete(buttonNumber)) {
            	theFrame.setMessageDown(buttonNumber, "✓");
            }
            else {
            	theFrame.setMessageDown(buttonNumber, "(" + String.valueOf(valueDown) + ")");
            }           
        }

        else if(timesPressed==1) {
            if(isSolved){
                c=Color.GREEN;
            }
            else {
                c=Color.BLUE;
            }
            this.setIcon(null);
            valueAcross = theGame.sumAcross(buttonNumber);
            valueDown = theGame.sumDown(buttonNumber);
            if(theGame.rowComplete(buttonNumber)) {
            	theFrame.setMessageAcross(buttonNumber, "✓");
            }
            else{
                theFrame.setMessageAcross(buttonNumber, "(" + String.valueOf(valueAcross) + ")");
            }
            if(theGame.colComplete(buttonNumber)) {
            	theFrame.setMessageDown(buttonNumber, "✓");
            }
            else {
            	theFrame.setMessageDown(buttonNumber, "(" + String.valueOf(valueDown) + ")");
            }
        }

        else {
            c=Color.GRAY;
        }
    }

    public void reset() {
        isSolved = false;
    	if(pressed){
    	timesPressed = 2;
    	this.doClick();   
    	}    
    }

    public void solve() {
        isSolved = true;
        timesPressed = 0;
        this.doClick();   
    }    
    
    
    public void actionPerformed(ActionEvent e) { 
        timesPressed += 1;
        pressed = true;
        beenHere(this);
    }
}