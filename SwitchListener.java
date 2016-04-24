import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwitchListener extends Switcher implements ActionListener {

    public SwitchListener(Puzzle p) {
        super(p);
        }

    public void actionPerformed(ActionEvent arg0) {

        super.specialDo();
        //super.validate();
        //super.repaint();
    }
    
}