import java.awt.event.ActionListener;


public class KenkenSwitcher extends Switcher implements ActionListener {

    public KenkenSwitcher(Puzzle menu) {
    	super(menu);        
    }

    public void specialDo() {
        menu.kenkenInit();
    }
}