import java.awt.event.ActionListener;


public class NonogramSwitcher extends Switcher implements ActionListener {

    public NonogramSwitcher(Puzzle menu) {
    	super(menu);        
    }

    public void specialDo() {
        menu.nonogramInit();
    }
}