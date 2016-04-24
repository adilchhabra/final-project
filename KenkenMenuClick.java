import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class KenkenMenuClick implements ActionListener {
    
    private KenkenFrame myFrame;
    private int valueInput;
    private int buttonNumber;

    
    public KenkenMenuClick(int toPass, int bNum, KenkenFrame fr) {
        myFrame = fr;
        valueInput = toPass;
        buttonNumber = bNum;
    }
    
    

    public void actionPerformed(ActionEvent e) {
        myFrame.displayChoice(valueInput, buttonNumber);
    }
    
    
}
