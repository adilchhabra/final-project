import java.awt.*;
import javax.swing.*;

public class KakurasuFrame extends Puzzle {
		private Color c = Color.gray;
		private JButton[] buttons = new JButton[81];
		private JButton[] kButtons = new JButton[26];
		private JButton[][] theGrid = new JButton[5][5];
		private KakurasuGame theGame = new KakurasuGame(this);
		private int count = 1;
		private int countRow =0;
		private int countCol =0;
		private int count2 = 1;
		private JLabel [] labelList = new JLabel[11];
        private Clock timer = new Clock();
        private Switcher switchBack = new Switcher(this);
        Container ct;		
		
		public void setUpFrame(Container contentPane) {
		ct = contentPane;
		this.setTitle("Kakurasu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//Container ct = getContentPane();
		ct.setLayout(new GridLayout(9,9)); 
		
		for(int i=0; i<81; i++) {
		JButton numberRowCol = new JButton("");
		int randomVal = 0;
		if(i==0) {
			JButton back = new JButton("Menu");
			back.addActionListener(switchBack);
			//back.addActionListener(new Switcher(new Puzzle()));
			ct.add(back);
			continue;
		}
		if(i==80) {
			JLabel empty = new JLabel("");
			ct.add(empty);
			continue;
		}
		//if(i==80) {
			//ct.add(timer);
			//CounterAnimateThread cat = new CounterAnimateThread(timer);
			//cat.start();
		//}
		if(i==72) {
			JButton solve = new JButton("Solve");
			solve.addActionListener(new SolverListener(theGame,this));
			ct.add(solve);
			continue;
		}
		if(i==8) {
			JButton reset = new JButton("Reset");
			reset.addActionListener(new ResetListener(theGame, this));
			ct.add(reset);
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
		else if(i==25) {
			numberRowCol = new JButton("15");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==34) {
			numberRowCol = new JButton("10");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==43) {
			numberRowCol = new JButton("11");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==52) {
			numberRowCol = new JButton("2");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==61) {
			numberRowCol = new JButton("3");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==65) {
			numberRowCol = new JButton("1");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==66) {
			numberRowCol = new JButton("10");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==67) {
			numberRowCol = new JButton("8");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==68) {
			numberRowCol = new JButton("4");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else if(i==69) {
			numberRowCol = new JButton("6");
			numberRowCol.setBackground(Color.YELLOW);
			numberRowCol.setOpaque(true);
		}
		else {
			numberRowCol = new KakurasuButton(c,count,this, theGame);
			kButtons[count] = numberRowCol;
			count = count + 1;
			theGrid[countRow][countCol] = numberRowCol;
			countCol += 1;
			if(countCol==5) {
				countRow += 1;
				countCol = 0;
			}
		}
		ct.add(numberRowCol);
		buttons[i]= numberRowCol;
		}

	}

   	public void setMessageAcross(int i,String s) {
   		int toChange = 0;
   		if(i<6){
   			toChange=1;
   		}
   		if(i>=6 && i<=10) {
   			toChange =2;
		}

		if(i>=11 && i<=15) {
			toChange=3;
		}
		if(i>=16 && i<=20) {
			toChange=4;
		}
		if(i>=21 && i<=25) {
			toChange=5;
		}
		labelList[toChange].setText(s);
   		if(s.equals("✓")) labelList[toChange].setForeground(Color.green);
   		else labelList[toChange].setForeground(Color.white);
   	}

   	public void setMessageDown(int i, String s) {
   		int toChange =0;
        if(i == 1 || i==6 || i==11 || i == 16 || i==21) {
        	toChange=6;
		}

		if(i == 2 || i==7 || i == 12 || i == 17 || i==22) {
			toChange=7;
		}

		if(i==3 || i==8 || i==13 || i == 18 || i==23) {
			toChange=8;
		}

		if(i==4 || i==9 || i == 14 || i == 19 || i==24) {
			toChange=9;
		}

		if(i== 5 || i==10 || i == 15 || i == 20 || i==25) {
			toChange=10;
		}
		labelList[toChange].setText(s);
   		if(s.equals("✓")) labelList[toChange].setForeground(Color.green);
   		else labelList[toChange].setForeground(Color.white);
   	}

   	public void reset() {
   		for(int i = 1; i<kButtons.length;i++) {
   			((KakurasuButton) kButtons[i]).reset();
   		}
   	}
   	
   	public JButton [][] getGrid () {
   		return theGrid;
   	}	

   	public void solve(){
   		int [][] solvedGrid = theGame.getSolvedGrid();
   		reset();
   		for(int i = 0; i < solvedGrid.length; i++) {
   			for(int j = 0; j< solvedGrid.length; j++) {
   				if(solvedGrid[i][j]==1) {
   					((KakurasuButton) theGrid[i][j]).solve();
   				}
   			}
   		}
   	}

   	public void init() {
   		super.init();
   	}



}