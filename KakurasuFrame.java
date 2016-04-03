import java.awt.*;
import javax.swing.*;

public class KakurasuFrame extends Puzzle {
		private Color c = Color.gray;
		private JButton[] buttons = new JButton[81];
		private KakurasuGame theGame = new KakurasuGame();
		private int count = 1;
		private int count2 = 1;
		private JLabel [] labelList = new JLabel[11];
        		
		public void setUpFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Container ct = getContentPane();
		ct.setLayout(new GridLayout(9,9)); //good idea to suppose 4x4 for program in initially
		//is it possible to choose what container in the grid to fill?
		
		for(int i=0; i<81; i++) {
		JButton numberRowCol;
		int randomVal = 0;
		if(i==0 || i== 8|| i==72 || i==80) {
			JLabel empty = new JLabel("");
			ct.add(empty);
			continue;
		}
		else if(i==1 || i ==2 || i==3 || i ==4 || i==5 || i ==6 || i==7 || i ==9 || i==17 || i==18 || i ==27 || i==36 || i ==45 || i==54 || i == 63 || i==10 || i ==16 || i==79 || i== 71 || i == 70 || i== 73 || i == 64) {
			JLabel empty = new JLabel("");
			empty.setBackground(Color.BLACK);
			empty.setOpaque(true);
			ct.add(empty);
			continue;
		}
		else if (i ==26 || i==35 || i == 44 || i==53 || i == 62 || i== 74 || i == 75 || i==76 || i== 77 || i == 78) {
			JLabel toUpdate = new JLabel("");
			toUpdate.setBackground(Color.BLACK);
			toUpdate.setOpaque(true);
			toUpdate.setHorizontalAlignment(SwingConstants.CENTER);
            toUpdate.setVerticalAlignment(SwingConstants.CENTER);
            toUpdate.setFont(new Font("Serif", Font.BOLD, 14));
            toUpdate.setForeground(Color.white);
            labelList[count2] = toUpdate;
			count2++;
			ct.add(toUpdate);
			continue;
		}
		else if(i==11) {
			numberRowCol = new JButton("1");
		}
		else if(i==12) {
			numberRowCol = new JButton("2");
		}
		else if(i==13) {
			numberRowCol = new JButton("3");	
		}
		else if(i==14) {
			numberRowCol = new JButton("4");
		}
		else if(i==15) {
			numberRowCol = new JButton("5");
		}
		else if(i==19) {
			numberRowCol = new JButton("1");
		}
		else if(i==28) {
			numberRowCol = new JButton("2");
		}
		else if(i==37) {
			numberRowCol = new JButton("3");
		}
		else if(i==46) {
			numberRowCol = new JButton("4");
		}
		else if(i==55) {
			numberRowCol = new JButton("5");
		}
		else if (i==25 || i==34 || i==43 || i==52 || i==61) {
			randomVal = randomWithRange(1,10); //check range
			theGame.setSumDown(randomVal);
			numberRowCol = new JButton(String.valueOf(randomVal)); 
		}
		else if (i==65 || i==66 || i==67 || i==68 || i==69) {
			randomVal = randomWithRange(1,10);
			theGame.setSumAcross(randomVal);
			numberRowCol = new JButton(String.valueOf(randomVal)); 
		}
		else {
			numberRowCol = new KakurasuButton(c,count,this, theGame);
			count = count + 1; 
		}
		ct.add(numberRowCol);
		buttons[i]= numberRowCol;
		}

	}

    public int randomWithRange(int min, int max) {
		int range = (max - min) + 1; 
   		return (int)(Math.random() * range) + min;
   } 

   	public void setMessageAcross(int i,String s) {
   		if(i<6){
   			labelList[1].setText(s);
   		}
   		if(i>=6 && i<=10) {
			labelList[2].setText(s);
		}

		if(i>=11 && i<=15) {
			labelList[3].setText(s);
		}
		if(i>=16 && i<=20) {
			labelList[4].setText(s);
		}

		if(i>=21 && i<=25) {
			labelList[5].setText(s);
		}
   	}

   	public void setMessageDown(int i, String s) {
        if(i == 1 || i==6 || i==11 || i == 16 || i==21) {
			labelList[6].setText(s);
		}

		if(i == 2 || i==7 || i == 12 || i == 17 || i==22) {
			labelList[7].setText(s);
		}

		if(i==3 || i==8 || i==13 || i == 18 || i==23) {
			labelList[8].setText(s);
		}

		if(i==4 || i==9 || i == 14 || i == 19 || i==24) {
			labelList[9].setText(s);
		}

		if(i== 5 || i==10 || i == 15 || i == 20 || i==25) {
			labelList[10].setText(s);
		}
   	}


}