import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class KenkenButtonEasy implements ActionListener {
    
    private JButton myButton;
    private int buttonNumber;
    JPopupMenu  menu;
    private KenkenFrame myFrame;
    private static boolean toReset = false;
    private int solvedVal;
    
    public KenkenButtonEasy(int bNum, KenkenFrame fr, JButton clicker, int sVal) {
    buttonNumber = bNum;
    myButton = clicker;
    myFrame = fr;
    solvedVal = sVal;
        // create a popup menu
        menu = new JPopupMenu("");    
            // create a menu item
        JMenuItem first = new JMenuItem("Back");
        // add the menu item to the menu
        menu.add(first);
        // add a listener to the menu item
     
        JMenuItem zeroDef = new JMenuItem("Default");
        zeroDef.addActionListener(new KenkenMenuClick(-1, buttonNumber, myFrame));
        menu.add(zeroDef);
        
        JMenuItem second = new JMenuItem("1");
        second.addActionListener(new KenkenMenuClick(1, buttonNumber, myFrame));
        menu.add(second);
           
        JMenuItem third = new JMenuItem("2");
        third.addActionListener(new KenkenMenuClick(2, buttonNumber, myFrame));

        menu.add(third);

        JMenuItem fourth = new JMenuItem("3");
        fourth.addActionListener(new KenkenMenuClick(3, buttonNumber, myFrame));

        menu.add(fourth);

        JMenuItem fifth = new JMenuItem("4");
        fifth.addActionListener(new KenkenMenuClick(4, buttonNumber, myFrame));
        menu.add(fifth);
    }

    public void reset() {
        toReset = true;
        myButton.doClick();
    }

    public void solve() {
        myFrame.displayChoice(solvedVal,buttonNumber);
    }

    public void setMenu() {
            // create a popup menu
        menu = new JPopupMenu("");    
            // create a menu item
        JMenuItem first = new JMenuItem("Back");
        // add the menu item to the menu
        menu.add(first);
        // add a listener to the menu item
     
        JMenuItem zeroDef = new JMenuItem("Default");
        zeroDef.addActionListener(new KenkenMenuClick(-1, buttonNumber, myFrame));
        menu.add(zeroDef);
        
        JMenuItem second = new JMenuItem("1");
        second.addActionListener(new KenkenMenuClick(1, buttonNumber, myFrame));
        menu.add(second);
           
        JMenuItem third = new JMenuItem("2");
        third.addActionListener(new KenkenMenuClick(2, buttonNumber, myFrame));

        menu.add(third);

        JMenuItem fourth = new JMenuItem("3");
        fourth.addActionListener(new KenkenMenuClick(3, buttonNumber, myFrame));

        menu.add(fourth);

        JMenuItem fifth = new JMenuItem("4");
        fifth.addActionListener(new KenkenMenuClick(4, buttonNumber, myFrame));
        menu.add(fifth);
    }

    public void actionPerformed(ActionEvent e) {
    if(toReset){
        myFrame.displayChoice(-1, buttonNumber);
        if(buttonNumber==15)
            toReset=false;
        }
    else {
        menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
        }
    }
    
    
}
