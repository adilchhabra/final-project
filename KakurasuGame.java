public class KakurasuGame extends PuzzleGame{

	int [] sumAcross = new int[5];
	int [] sumDown = new int [5];
	int across = 0;
	int down = 0;
	static int [] sumValueAcross = new int[5];
	static int [] sumValueDown = new int[5];
	static int [][] theGrid = new int[5][5];
	private int [] rowSum = {15,10,11,2, 3};
	private int [] colSum = {1,10,8,4,6};
	private int [][] buttonNumber = new int [5][5];
	private KakurasuFrame theFrame;
	private Solver iSolve = new Solver(this);
	 public KakurasuGame(KakurasuFrame fr) { //one parameter constructor
		theFrame = fr;    
    }

    public void reset() {
    	for(int i = 0; i<sumValueAcross.length; i++){
    		sumValueAcross[i]=0;
    		sumValueDown[i]=0;
    	} 
    }
    public void setSumAcross(int num) {
		sumAcross[across]=num;
		across += 1;
	}

	public void setSumDown(int num) {
		sumDown[down] = num;
		down += 1;
	}

	public boolean rowComplete(int i) {
		int row = getRowNumber(i);
		return sumValueAcross[row] == rowSum[row];
	}

	public boolean colComplete(int i) {
		int col = getColNumber(i);
		return sumValueDown[col] == colSum[col];
	}

	public int sumAcross(int i) {
		int temp = getValueAcross(i);
		int row = getRowNumber(i);
		sumValueAcross[row]+= temp;
		return sumValueAcross[row];
	}

	public int setAcrossEmpty(int i) {
		int temp = getValueAcross(i);
		int row = getRowNumber(i);
		sumValueAcross[row]-=temp;
		return sumValueAcross[row];
	}

	public int getAcross(int i) {
		int row = getRowNumber(i);
		return sumValueAcross[row];
	}

	public int sumDown(int i) {
		int temp = getValueDown(i);
		int col = getColNumber(i);
		sumValueDown[col]+= temp;
		return sumValueDown[col];
	}

	public int setDownEmpty(int i) {
		int temp = getValueDown(i);
		int col = getColNumber(i);
		sumValueDown[col]-=temp;
		return sumValueDown[col];
	}

	public int getDown(int i) {
		int col = getColNumber(i);
		return sumValueDown[col];
	}

	public int getRowNumber(int i) {
		if(i<6){
			return 0;
		}
		if(i>=6 && i<=10) {
			return 1;
		}
		if(i>=11 && i<=15) {
			return 2;
		}
		if(i>=16 && i<=20) {
			return 3;
		}
		if(i>=21 && i<=25) {
			return 4;
		}
		return -1;
	}

	public int getColNumber(int i) {

		if(i== 1 || i==6 || i==11 || i == 16 || i==21) {
			return 0;
		}

		if(i==2 || i==7 || i == 12 || i == 17 || i==22) {
			return 1;
		}

		if(i==3 || i==8 || i==13 || i == 18 || i==23) {
			return 2;
		}

		if(i==4 || i==9 || i == 14 || i == 19 || i==24) {
			return 3;
		}

		if(i==5 || i==10 || i == 15 || i == 20 || i==25) {
			return 4;
		}
		return -1;
	}

	public int getValueAcross(int i) {
		return getColNumber(i)+1;
	}
	public int getUnsetValue(){
		return 0;
	}
	public int getValueDown(int i) {
		return getRowNumber(i)+1;
	}
	
	public int [][] getGrid() {
		for(int i = 0; i<theGrid.length; i++) {
			for(int j=0; j<theGrid.length; j++) {
				theGrid[i][j]=0;
			}
		}
		int count = 1;
		for(int i = 0; i<buttonNumber.length; i++) {
			for(int j=0; j<buttonNumber.length; j++) {
				buttonNumber[i][j]=count;
				count += 1;
			}
		}
		return theGrid;
	} 	

	public boolean rowConstraint(int [][] theGrid) {
		int count = 1;
		for (int i =0; i<theGrid.length;i++) {
			int sum = 0;
			for(int j=0; j<theGrid.length; j++) {
				if(theGrid[i][j]==1) {
					sum += getValueAcross(buttonNumber[i][j]);
				}
			}
			if(sum!=rowSum[i])
				return false;
		}
		return true;
	}

	public boolean colConstraint(int [][] theGrid) {
		for (int j =0; j<theGrid.length;j++) {
			int sum = 0;
			for(int i=0; i<theGrid.length; i++) {
				if(theGrid[i][j]==1) {
				sum += getValueDown(buttonNumber[i][j]);
				}
			}
			if(sum!=colSum[j])
				return false;
		}
		return true;
	}

	public void solve() {
		int [][] solvedGrid = iSolve.getSolvedGrid();
		//iSolve.printGrid(solvedGrid);
		//if(iSolve.getResult()) {
		//	System.out.println("I'm on my way!");
		//}
	}

	public int [][] getSolvedGrid(){
		this.reset();
		int [][] solvedGrid = iSolve.getSolvedGrid();
		return solvedGrid;
	}

	public int [] getPossibles() {
		int [] possibleValues = {0,1};
		return possibleValues;
	}

	public boolean checkConstraints(int [][] theGrid) {
		return rowConstraint(theGrid) && colConstraint(theGrid);
	}

	public boolean checkPossibleConstraints(int [][] theGrid) {
		return rowPossibleConstraint(theGrid) && colPossibleConstraint(theGrid);
	}

	public boolean rowPossibleConstraint(int [][] theGrid) {

		for (int i =0; i<theGrid.length;i++) {
			int sum = 0;
			for(int j=0; j<theGrid.length; j++) {
				if(theGrid[i][j]==1) {
				sum += getValueAcross(buttonNumber[i][j]); //insert i,j button
					if(sum > rowSum[i])
						return false;
				}
				
			}
		}
		return true;
	}

	public boolean colPossibleConstraint(int [][] theGrid) {
		for (int j =0; j<theGrid.length;j++) {
			int sum = 0;
			for(int i=0; i<theGrid.length; i++) {
				if(theGrid[i][j]==1) {
				sum += getValueDown(buttonNumber[i][j]);
					if(sum>colSum[j])
						return false;
				}	
			}
		}
		return true;
	}
}

