import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NonogramFrame extends Puzzle {
		private NonogramGame theGame = new NonogramGame(this);	
        Container ct;
        private JButton [][] buttonGrid = new JButton[10][5];
        private int countRow=0;
        private int countCol=0;		
		
		public void setUpFrame(Container contentPane) {
		ct = contentPane;
		this.setTitle("Nonogram");
		this.setSize(new Dimension(1600,800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ct.setLayout(new GridLayout(16,11)); 
		JLabel space;
		JButton canClick;
		for(int i=0; i< 160; i++) {
			if(i==0) {
				JButton menu = new JButton("Menu");
				ct.add(menu);
				continue;
			}
			if(i==9) {
				JButton reset = new JButton("Reset");
				reset.addActionListener(new ResetListener(theGame, this));
				ct.add(reset);
				continue;
			}
			if(i==150) {
				JButton solve = new JButton("Solve");
				//solve.addActionListener(new SolverListener(theGame,this));
				ct.add(solve);
				continue;
			}
			if(i==159) {
				JButton checker = new JButton("Check");
				//checker.addActionListener(new CheckerListener(theGame,this));
				ct.add(checker);
				continue;
			}
			if(i==1|| i==2||i==3||i==4|| i==5 || i==6|| i==7 || i==8 || i==151||i==152|| i==153||i==154||i==155||i==156||i==157||i==158||i==10|| i==20||i==30||i==40||i==50 || i==60|| i==70 || i==80 || i==90||i==100 || i==110|| i==120||i==130||i==140||i==19|| i==29||i==39||i==49||i==59|| i==69 || i==79 || i==89 || i==99||i==109 || i==119|| i==129||i==139||i==149) {
				space = new JLabel("");
				space.setBackground(Color.pink);
				space.setOpaque(true);
				ct.add(space);
				continue;
			}
			if(i==11 || i==12 || i==21 || i==22 || i==23 || i==31 || i==32 || i==33 || i==42 || i==43)  {
				space = new JLabel("");
				space.setBackground(Color.pink);
				space.setOpaque(true);
				ct.add(space);
				continue;
			}
			if(i==41) {
				JLabel forColSize = new JLabel("10");
				setSideLabels(forColSize);
				forColSize.setBackground(Color.pink);
				forColSize.setForeground(Color.BLACK);
				forColSize.setFont(new Font("Serif", Font.BOLD, 14));
				forColSize.setBorder(BorderFactory.createMatteBorder(4,4,0,4,Color.BLACK));
				ct.add(forColSize);
				continue;
			}
			if(i==13) {
				JLabel forRowSize = new JLabel("5");
				setSideLabels(forRowSize);
				forRowSize.setBackground(Color.pink);
				forRowSize.setForeground(Color.BLACK);
				forRowSize.setFont(new Font("Serif", Font.BOLD, 14));
				forRowSize.setBorder(BorderFactory.createMatteBorder(4,4,4,0,Color.BLACK));
				ct.add(forRowSize);
				continue;
			}

			if(i==51) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(4,4,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==141) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,4,4,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==61 || i==71 || i==81 || i==111 || i==121 || i==131) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,4,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==52) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(4,0,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==142) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,4,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i== 82 || i==112) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==53) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(4,0,1,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==62) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==63 || i==73 || i ==123) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,1,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==72 || i== 122 || i==132) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==83) {
				space = new JLabel("3");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,1,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==91) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,4,2,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==92) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==93) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,2,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==101) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(2,4,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==102) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(2,0,1,0,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==103) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(2,0,1,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==14) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(4,4,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==113 || i==133) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,1,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==143) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,4,4,Color.BLACK));
				ct.add(space);
				continue;
			}

			
			if(i==18) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(4,0,0,4,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==15 || i==16 || i==17) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(4,0,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i == 28) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,0,4,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==26 || i==27 || i==36) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==24) {
				space = new JLabel("");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,4,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==25) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==34) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,4,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}
			
			if(i==35 || i==37) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==38) {
				space = new JLabel("2");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,0,4,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==44) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,4,4,1,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==45 || i==47) {
				space = new JLabel("3");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,4,1,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==46) {
				space = new JLabel("7");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,4,1,Color.BLACK));
				ct.add(space);
				continue;
			}

			if(i==48) {
				space = new JLabel("1");
				setSideLabels(space);
				space.setBorder(BorderFactory.createMatteBorder(0,0,4,4,Color.BLACK));
				ct.add(space);
				continue;
			}
			if(i==98) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(1,1,2,4,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			if(i==108) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(2,1,1,4,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			if(i==148) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(1,1,4,4,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			if(i==94 || i == 95 || i == 96 || i== 97) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(1,1,2,1,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			if(i==104 || i == 105 || i == 106 || i== 107) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(2,1,1,1,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			if(i==58 || i == 68 || i == 78 || i== 88 || i==118 || i==128 || i==138) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(1,1,1,4,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			if(i==144 || i == 145 || i == 146 || i== 147) {
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(1,1,4,1,Color.BLACK));		
				ct.add(canClick);
				continue;
			}
			else{
				canClick = new NonogramButton(theGame);
				addToGrid(canClick);	
				canClick.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));		
				ct.add(canClick);
				continue;
				}

		}

	}

	public void addToGrid(JButton canClick) {
		buttonGrid[countRow][countCol] = canClick;
		countCol += 1;
		if(countCol==5) {
			countRow += 1;
			countCol=0;
		}
	}

	public void reset() {
		for(int i = 0; i< buttonGrid.length; i++) {
			for(int j =0; j< buttonGrid[0].length; j++) {
				((NonogramButton)buttonGrid[i][j]).reset();
			}
		}
	}
	public void setSideLabels(JLabel space) {
		space.setBackground(Color.darkGray);
		space.setOpaque(true);
		space.setHorizontalAlignment(SwingConstants.CENTER);
        space.setVerticalAlignment(SwingConstants.CENTER);
        space.setForeground(Color.WHITE);
	}
}