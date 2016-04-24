public class KenkenGame extends PuzzleGame{


	private Puzzle theFrame;
	private Solver iSolve = new Solver(this);
	private int [][] userSolved = new int [4][4];
	private int [][] solvedGrid;
	
	public KenkenGame(Puzzle fr) { 
		theFrame = fr;  
    }

    public void reset() {
	
    }

    public void solve() {
		solvedGrid = iSolve.getSolvedGrid();
	}

	public boolean checkConstraints(int [][] theGrid) {
		for(int i = 0; i< theGrid.length; i++) {
			int count1 =0, count2 = 0, count3 = 0, count4 = 0;
			for(int j = 0; j<theGrid.length; j++) {
				if(theGrid[i][j]==1)
					count1 += 1;
				if(theGrid[i][j]==2)
					count2 += 1;
				if(theGrid[i][j]==3)
					count3 += 1;
				if(theGrid[i][j]==4)
					count4 += 1;
			}
			if(count1 !=1 || count2 !=1 || count3 !=1 || count4 !=1)
				return false;
		}
		for(int j = 0; j< theGrid.length; j++) {
			int count1 =0, count2 = 0, count3 = 0, count4 = 0;
			for(int i = 0; i<theGrid.length; i++) {
				if(theGrid[i][j]==1)
					count1 += 1;
				if(theGrid[i][j]==2)
					count2 += 1;
				if(theGrid[i][j]==3)
					count3 += 1;
				if(theGrid[i][j]==4)
					count4 += 1;
			}
			if(count1 !=1 || count2 !=1 || count3 !=1 || count4 !=1)
				return false;
		}
		if(Math.abs(theGrid[0][0]-theGrid[1][0])!=1) {
			return false;
		}
		if(Math.abs(theGrid[0][1]-theGrid[1][1])!=1) {
			return false;
		}

		if(theGrid[0][2]/theGrid[0][3]!=2 && theGrid[0][3]/theGrid[0][2]!=2) {
			return false;
		}

		if(theGrid[1][2]+theGrid[2][2]!=5) {
			return false;
		}

		if(theGrid[1][3]+theGrid[2][3]!=7) {
			return false;
		}

		if(Math.abs(theGrid[2][0]-theGrid[3][0])!=3) {
			return false;
		}
		if(theGrid[3][2]*theGrid[3][3]!=6) {
			return false;
		}
		

		if(theGrid[2][1]/theGrid[3][1]!=2 && theGrid[3][1]/theGrid[2][1]!=2) {
			return false;
		}

		return true;
	}
    public boolean checkPossibleConstraints(int [][] theGrid) {
		
		for(int i = 0; i< theGrid.length; i++) {
			int count1 =0, count2 = 0, count3 = 0, count4 = 0;
			for(int j = 0; j<theGrid.length; j++) {
				if(theGrid[i][j]==1)
					count1 += 1;
				if(theGrid[i][j]==2)
					count2 += 1;
				if(theGrid[i][j]==3)
					count3 += 1;
				if(theGrid[i][j]==4)
					count4 += 1;
			}
			if(count1 >1 || count2 >1 || count3 >1 || count4 >1)
				return false;
		}
		for(int j = 0; j< theGrid.length; j++) {
			int count1 =0, count2 = 0, count3 = 0, count4 = 0;
			for(int i = 0; i<theGrid.length; i++) {
				if(theGrid[i][j]==1)
					count1 += 1;
				if(theGrid[i][j]==2)
					count2 += 1;
				if(theGrid[i][j]==3)
					count3 += 1;
				if(theGrid[i][j]==4)
					count4 += 1;
			}
			if(count1 >1 || count2 >1 || count3 >1 || count4 >1)
				return false;
		}

		if(theGrid[0][0]!= 0 && theGrid[1][0]!=0) {
			if(Math.abs(theGrid[0][0]-theGrid[1][0])!=1) {
				return false;
			}
		}
		
		if(theGrid[0][1]!=0 && theGrid[1][1]!=0) {
			if(Math.abs(theGrid[0][1]-theGrid[1][1])!=1) {
				return false;
			}
		}
		if(theGrid[2][0]!=0 && theGrid[3][0]!=0) {
			if(Math.abs(theGrid[2][0]-theGrid[3][0])!=3) {
				return false;
			}
		}
		if(theGrid[1][2]!=0 && theGrid[2][2]!=0) {
			if(theGrid[1][2]+theGrid[2][2]!=5) {
				return false;
			}
		}
		if(theGrid[1][3]!=0 && theGrid[2][3]!=0) {
			if(theGrid[1][3]+theGrid[2][3]!=7) {
				return false;
			}
		}
		
		if(theGrid[0][2]!=0 && theGrid[0][3]!=0) {
			if(theGrid[0][2]/theGrid[0][3]!=2 && theGrid[0][3]/theGrid[0][2]!=2) {
				return false;
			}
		}

		if(theGrid[2][1]!=0 && theGrid[3][1]!=0) {
			if(theGrid[2][1]/theGrid[3][1]!=2 && theGrid[3][1]/theGrid[2][1]!=2) {
			return false;
			}
		}
		
		if(theGrid[3][2]!=0 && theGrid[3][3]!=0) {	
			if(theGrid[3][2]*theGrid[3][3]!=6) {
				return false;
			}
		}
		
		
		return true;
		}

	public int[][] getGrid() {
		int [][] a = new int [4][4]; 
		return a;
	}
	public int [] getPossibles() {
		int [] possibleValues = {1,2,3,4};
		return possibleValues;
	}
	public int getUnsetValue(){
		return 1;
	}

	public int [][] getSolvedGrid() {
		this.reset();
		return solvedGrid;
	}

	public void sendInput(int value, int buttonNumber, int [][] correspondingValues) {
		int row = getRow(buttonNumber,correspondingValues);
		int col = getCol(buttonNumber,correspondingValues);
		userSolved[row][col]=value;
	}

	public boolean userCorrect() {
		solve();
		for(int i = 0; i< userSolved.length; i++) {
			for(int j =0; j<userSolved.length; j++) {
				if(userSolved[i][j]!=solvedGrid[i][j]) {
					System.out.println("Not the same.");
					return false;			
				}
			}
		}
		return true;
	}

	public int getRow(int buttonNumber, int [][] correspondingValues) {
		for(int i = 0; i< correspondingValues.length; i++) {
			for(int j =0; j<correspondingValues.length; j++) {
				if(correspondingValues[i][j]==buttonNumber)
					return i;
			}
		}
		return -1;
	}

	public int getCol(int buttonNumber, int [][] correspondingValues) {
		for(int i = 0; i< correspondingValues.length; i++) {
			for(int j =0; j<correspondingValues.length; j++) {
				if(correspondingValues[i][j]==buttonNumber)
					return j;
			}
		}
		return -1;
	}
}

