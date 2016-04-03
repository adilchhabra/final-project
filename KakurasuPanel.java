import java.awt.*;
import javax.swing.JPanel;

public class KakurasuPanel extends JPanel { 
    
    private Color col; 
    private int valPressed = 0;


    public KakurasuPanel() { 
    setPreferredSize(new Dimension(100,100)); 
    //col2 = makeRandomColor(); 
    //g.setColor(col);


    }

    public void paintComponent(Graphics g) { 
    //Graphics obtained from Java AWT      
        g.drawString("(" + String.valueOf(valPressed) + ")",50,50); //50 are x and y components of text "Your First GUI Program"
    }


}