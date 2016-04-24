import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KenkenFrame extends Puzzle {
		private Color c = Color.gray;
		private JLabel [] kButtons = new JLabel[50];
		private int count=0;
		private int countRow = 0;
		private int countCol = 0;
		private JButton [][] theGrid = new JButton[4][4];
		private JButton toClick;
		private KenkenGame theGame = new KenkenGame(this);
		private int [][] correspondingValues  = new int [4][4];
		private Color ourColor = null;
		private MouseListener ml;
		private boolean toMouse = true;
		Color highlight = Color.cyan;
		Color correctCol = Color.green;

		
        Container ct;		
		
		public void setUpFrame(Container contentPane) {
		ct = contentPane;
		this.setTitle("KenKen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ct.setLayout(new GridLayout(6,6)); 
		JButton checker = new JButton("Check");
		JButton empty;
		GridBagConstraints c = new GridBagConstraints();
			c.gridx=0;
			c.gridy=0;
			c.ipadx=25;
			c.ipady=30;
			c.insets = new Insets(0,5,0,0);
			c.anchor= GridBagConstraints.FIRST_LINE_START;
			c.gridwidth=1;
			c.gridheight=1;
		GridBagConstraints d = new GridBagConstraints();
			d.ipady=10;
			d.ipadx=10;
			d.gridx=1;
			d.gridy=1;
			d.gridwidth=2;
			d.gridheight=2;
			d.insets = new Insets(-15,-15,10,10);
		setCorresponding(correspondingValues);
		for(int i=0; i< 36; i++) {
			if(i==0) {
				JButton menu = new JButton("Menu");
				ct.add(menu);
				continue;
			}
			if(i==5) {
				JButton reset = new JButton("Reset");
				reset.addActionListener(new ResetListener(theGame, this));
				ct.add(reset);
				continue;
			}
			if(i==1|| i==2||i==3||i==4||i==6||i==12||i==18|| i==24||i==11||i==17||i==23||i==29||i==31||i==32||i==33||i==34) {
				JLabel space = new JLabel("");
				space.setBackground(Color.ORANGE);
				space.setOpaque(true);
				ct.add(space);
				continue;
			}
			if(i==30) {
				JButton solve = new JButton("Solve");
				solve.addActionListener(new SolverListener(theGame,this));
				ct.add(solve);
				continue;
			}
			if(i==35) {
				checker.addActionListener(new CheckerListener(theGame,this));
				ct.add(checker);
				continue;
			}
			if(i==7) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("1-");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(4,4,1,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==8) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("1-");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(4,0,1,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==9) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("2÷");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(4,0,2,1,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==10) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(4,0,2,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==13) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(0,4,2,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==14) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(0,0,2,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==15) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("5+");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(2,0,1,2,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==16) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("7+");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(2,2,1,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==19) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("3-");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(2,4,1,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==20) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("2÷");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(2,0,1,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==21) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==22) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(0,2,2,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==25) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(0,4,4,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==26) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(0,0,4,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==27) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("6x");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(2,0,4,1,Color.BLACK));
				ct.add(toClick);
				continue;
			}
			if(i==28) {
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));		
				JLabel operationHere = new JLabel("   ");
				setButtonDesign(toClick,operationHere,c,d);
				toClick.setBorder(BorderFactory.createMatteBorder(2,0,4,4,Color.BLACK));
				ct.add(toClick);
				continue;
			}


			else{
				toClick = new KenkenButton();
				toClick.addActionListener(new KenkenButtonEasy(count,this,toClick,0));
				//kButtons[count]=toClick;
				count += 1;
				ct.add(toClick);
				}
			}
		}
	
		public void setCorresponding(int [][] a) {
			int addValue = 0;
			for (int i = 0; i< a.length; i++) {
				for(int j=0;j<a.length;j++) {
					a[i][j] = addValue;
					addValue += 1;
				}
			} 
		}
		public void displayChoice(int value, int buttonNum) {
		theGame.sendInput(value,buttonNum,correspondingValues);
		if(value == -1) {
			kButtons[buttonNum].setText("");
			}
		else {
			kButtons[buttonNum].setText(String.valueOf(value));
			}
		}

		public void reset() {
			for(int i = 0; i< theGrid.length; i++) {
				for (int j = 0; j<theGrid.length; j++) {
					KenkenButtonEasy toReset = new KenkenButtonEasy(correspondingValues[i][j], this, theGrid[i][j],0);
					toReset.reset();
					ourColor = null;
					theGrid[i][j].setBackground(ourColor);
					toMouse=true;
				}
			}
		}
		public void setButtonDesign(JButton toClick, JLabel operationHere, GridBagConstraints c, GridBagConstraints d) {
			toClick.setLayout(new GridBagLayout());
			operationHere.setFont(new Font("Serif", Font.BOLD, 20));
			operationHere.setLocation(20,20);
			toClick.add(operationHere,c);
			JLabel valueDisplay = new JLabel("");
			valueDisplay.setFont(new Font("Serif", Font.BOLD, 40));
			toClick.add(valueDisplay,d); 
			kButtons[count]=valueDisplay;
			count += 1;
			theGrid[countRow][countCol] = toClick;
			countCol += 1;
			if(countCol==4) {
				countRow += 1;
				countCol = 0;
			}
			toClick.setBorder(BorderFactory.createRaisedBevelBorder());
			
			toClick.addMouseListener(ml = new java.awt.event.MouseAdapter() {
			public void mouseEntered(MouseEvent e){

				if(toMouse) 
					ourColor=highlight;
				else
					ourColor = correctCol;
				toClick.setBackground(ourColor);
				toClick.setOpaque(true);
			}
			public void mouseExited(MouseEvent e){
				if(ourColor==highlight)
					toClick.setBackground(null);
				else if(ourColor == correctCol) {
					toClick.setBackground(correctCol);
				}
				else {
					toClick.setBackground(null);
				}
				toClick.setOpaque(true);
			}
			public void mouseClicked(MouseEvent e) 
			{}
			public void mousePressed(MouseEvent e) 
			{}	
			public void mouseReleased(MouseEvent e)
			{}
			});
							
		}

		public void solve() {
			int [][] solvedGrid = new int[4][4];
			solvedGrid = theGame.getSolvedGrid();
			reset();
   			for(int i = 0; i < solvedGrid.length; i++) {
   				for(int j = 0; j< solvedGrid.length; j++) {
   						KenkenButtonEasy toSolve = new KenkenButtonEasy(correspondingValues[i][j], this, theGrid[i][j], solvedGrid[i][j]);
   						toSolve.solve();  					
   				}
   			}
		}

		public void check() {
			for(int i = 0; i < theGrid.length; i++) {
   				for(int j = 0; j< theGrid.length; j++) {
   						ourColor = correctCol;
   						theGrid[i][j].setBackground(ourColor);
						theGrid[i][j].setOpaque(true);
						toMouse=false;
						//theGrid[i][j].removeMouseListener(ml);					
   				}
   			}
		}

		public void checkFail() {
			for(int i = 0; i < theGrid.length; i++) {
   				for(int j = 0; j< theGrid.length; j++) {
   					toMouse=true;	
   					ourColor = Color.red;
   					theGrid[i][j].setBackground(ourColor);
					theGrid[i][j].setOpaque(true);		 					
   				}
   			}
		}

}