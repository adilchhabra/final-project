import javax.swing.*;
import java.awt.*;


public class Puzzle extends JFrame {
	 Container contentPane = getContentPane(); 
	public void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new BorderLayout());
		JLabel iPane = new JLabel(new ImageIcon("bgpuzzle.jpg"));
		contentPane.add(iPane);
        iPane.setLayout(new FlowLayout());
        JLabel l1=new JLabel("WELCOME TO PUZZLE FUN!");
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));


        JButton b1=new JButton("Kakurasu");
        b1.addActionListener(new KakurasuSwitcher(this));
        JButton b2=new JButton("KenKen");
        b2.addActionListener(new KenkenSwitcher(this));
        JButton b3=new JButton("Nonogram");
        b3.addActionListener(new NonogramSwitcher(this));
        iPane.add(l1);
        iPane.add(b1);
        iPane.add(b2);
        iPane.add(b3);
        }

    public void kakurasuInit(){
   		KakurasuFrame gameFrame = new KakurasuFrame();
   		gameFrame.setUpFrame(contentPane);
   		gameFrame.setPreferredSize(new Dimension(500,500));
   		gameFrame.pack();
    } 

    public void kenkenInit() {
    	KenkenFrame gameFrame = new KenkenFrame();
    	gameFrame.setUpFrame(contentPane);
   		gameFrame.setPreferredSize(new Dimension(500,500));
   		gameFrame.pack();
    }

    public void nonogramInit() {
      NonogramFrame gameFrame = new NonogramFrame();
      //gameFrame.setSize(new Dimension(1000,1000));
      gameFrame.setUpFrame(contentPane);
      gameFrame.pack();
    }

    public static void main(String [] args) {
		Puzzle theFrame = new Puzzle();
		theFrame.init();
		theFrame.setPreferredSize(new Dimension(500,500));

		theFrame.pack();
		theFrame.setVisible(true);
	}    

  public void reset() {
    
  }
  public void solve() {
    
  }

  public void check() {

  }

  public void checkFail() {
    
  }
} 