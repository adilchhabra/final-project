import java.awt.*;
import javax.swing.*;


public class GameMenu extends Puzzle {

		public void setUpFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("bgpuzzle.jpg")));
        setLayout(new FlowLayout());
        JLabel l1=new JLabel("WELCOME TO PUZZLE FUN!");
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        JButton b1=new JButton("Kakurasu");
        b1.addActionListener(new KakurasuSwitcher(this));
        add(l1);
        add(b1);
        }
	
} 