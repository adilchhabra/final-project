import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends Puzzle implements ActionListener {

		public void setUpFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("bgpuzzle.jpg")));
        setLayout(new FlowLayout());
        JLabel l1=new JLabel("WELCOME TO PUZZLE FUN!");
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        JButton b1=new JButton("Kakurasu");
        b1.addActionListener(this);
        add(l1);
        add(b1);
}
        public void actionPerformed(ActionEvent e) {
        	Puzzle gameFrame = new KakurasuFrame();
        	gameFrame.setUpFrame();
			gameFrame.setPreferredSize(new Dimension(500,500));
			gameFrame.pack();	
			gameFrame.setVisible(true);  
        }
	
} 