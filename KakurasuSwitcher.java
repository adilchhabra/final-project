import java.awt.event.ActionListener;


public class KakurasuSwitcher extends Switcher implements ActionListener {

    public KakurasuSwitcher(Puzzle menu) {
    	super(menu);        
    }

    public void specialDo() {
        menu.kakurasuInit();
    }
}