public class Solver {
	private PuzzleGame theGame;
	private int [][] theGrid;
	private int [] possibleValues;
	private boolean result;

	public Solver(PuzzleGame g) {
		theGame = g;
		theGrid = g.getGrid();
		possibleValues = g.getPossibles();
		result = label(theGrid, g, possibleValues, 0,0); //assume possibleValues 
	}

    public void printGrid(int [][] a) {
    	for (int i = 0; i< a.length; i++) {
			for (int j= 0; j< a.length; j++) {
				System.out.print("  " + a[i][j]);
    		}
    		System.out.println("");
    	}
    }

    public int [][] getSolvedGrid() {
        return theGrid;
    }
    public boolean getResult() {
    	return result;
    }
    public boolean label(int [][] theGrid, PuzzleGame g, int [] possibleValues, int row, int col) {
    	if(row==theGrid.length) {
    		return g.checkConstraints(theGrid);
    	}
    	for(int v: possibleValues) {
    		theGrid[row][col] = v;
    		boolean check = g.checkPossibleConstraints(theGrid);
    		if(check) {
    			int newCol = col+1;
    			int newRow = row;
    			if(newCol == theGrid[row].length) {
    				newCol = 0;
    				newRow = row +1;
    			}
    			if(label(theGrid, g, possibleValues, newRow, newCol)) {
    				return true;
    			}
    		}
    	}
    	theGrid[row][col]=0;
    	return false;
    }

}