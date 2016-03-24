import java.awt.*;
import javax.swing.*;

public class KakurasuFrame extends Puzzle {
		private Color c = Color.gray;
		private JButton[] buttons = new JButton[36];

		public void setUpFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Container ct = getContentPane();
		ct.setLayout(new GridLayout(6,6));

		//JLabel label1 = new JLabel("Let's play kakurasu!");
		//ct.add(label1);
		
		for(int i=0; i<36; i++) {
		JButton numberRowCol;
		if(i==0 || i== 5|| i==30 || i==35) {
			JLabel empty = new JLabel("");
			ct.add(empty);
			continue;
		}
		if(i==1) {
			numberRowCol = new JButton("1");
		}
		else if(i==2) {
			numberRowCol = new JButton("2");
		}
		else if(i==3) {
			numberRowCol = new JButton("3");	
		}
		else if(i==4) {
			numberRowCol = new JButton("4");
		}
		else if(i==6) {
			numberRowCol = new JButton("1");
		}
		else if(i==12) {
			numberRowCol = new JButton("2");
		}
		else if(i==18) {
			numberRowCol = new JButton("3");
		}
		else if(i==24) {
			numberRowCol = new JButton("4");
		}
		else if (i==11 || i==17 || i==23 || i==29 || i==31 || i==32 || i==33 || i==34) {
			numberRowCol = new JButton(String.valueOf(randomWithRange(1,16))); //make special kind of button
		}
		else {
			numberRowCol = new KakurasuButton(c); //make special kind of button
		}
		ct.add(numberRowCol);
		buttons[i]= numberRowCol;
		}

	}

       public int randomWithRange(int min, int max) {
   		int range = (max - min) + 1;     
   		return (int)(Math.random() * range) + min;
   } 



}