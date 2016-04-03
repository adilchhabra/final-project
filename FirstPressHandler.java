import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPressHandler implements ActionListener {
	
	private KakurasuGame g;
	private KakurasuButton button;
	private KakurasuFrame theFrame;
	private int buttonNumber;

	public FirstPressHandler(KakurasuButton b, int i, KakurasuFrame f) {
		this.button = b;
		this.buttonNumber = i;
		this.theFrame = f;
	} 

	public void actionPerformed(ActionEvent e) {
		System.out.println("Hey");
	}
}
