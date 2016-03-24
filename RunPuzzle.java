import javax.swing.*;
import java.awt.*;

public class RunPuzzle extends JFrame {
	
	public static void main(String [] args) {
		Puzzle theFrame = new GameMenu();
		theFrame.setUpFrame();
		theFrame.setPreferredSize(new Dimension(500,500));

		theFrame.pack();
		theFrame.setVisible(true);

	}
} 