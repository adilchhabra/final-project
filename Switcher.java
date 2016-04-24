import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Switcher implements ActionListener {

    Puzzle menu;

    public Switcher(Puzzle m) {
        menu = m;
    }

    public void specialDo() {
        menu.init();
    }

    public void actionPerformed(ActionEvent e) {
        menu.getContentPane().removeAll();
        specialDo();
        menu.validate();
        menu.repaint();
    }
}