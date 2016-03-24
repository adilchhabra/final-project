import java.awt.*;
import javax.swing.*;

public class KakurasuFrame extends Puzzle {

		public void setUpFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ct = getContentPane();
		ct.setLayout(new GridLayout(4,0));

		JLabel label1 = new JLabel("Let's play kakurasu!");
		ct.add(label1);

	}

}