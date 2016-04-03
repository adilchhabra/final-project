public class KakurasuGame {

	int [] sumAcross = new int[5];
	int [] sumDown = new int [5];
	int across = 0;
	int down = 0;
	private static boolean [] buttonsPressed = new boolean[26];

	 public KakurasuGame() { //one parameter constructor
	 	for(int i = 1; i < buttonsPressed.length; i++) {
	 		buttonsPressed[i] = false;
	 		//System.out.println("All to false");
	 	}
    }

    /*public void badSpot() { //if wrong button is pressed
        doneMessage = "You Lose - Good!";
    }
    
    public void spot() { //right button pressed
        howManyPushed++;
        if (howManyPushed == limit)
            doneMessage = "Curses, you win";
    }
    
    public String getDoneMessage() { //returns end message of the game
        return doneMessage;
    }

    public int howManyButtons() { //returns number of buttons
        return howMany;
    }
*/

    public void pressedTrue(int i) {
    	buttonsPressed[i] = true;
    	System.out.print("I'm true!");
    }

    public void setSumAcross(int num) {
		sumAcross[across]=num;
		across += 1;
	}

	public void setSumDown(int num) {
		sumDown[down] = num;
		down += 1;
	}


	public int setValueAcross(int i) {
		int value = 0;
		if(i<6) {
			for(int j=1; j<6; j++){
				if(buttonsPressed[j]) {
					value += getValueAcross(j);
				}	
			}
			
		}
		return value;
	}
	public int getValueAcross(int i) {
		if(i<6){
			return i;
		}

		if(i==6 || i==11 || i == 16 || i==21) {
			return 1;
		}

		if(i==7 || i == 12 || i == 17 || i==22) {
			return 2;
		}

		if(i==8 || i==13 || i == 18 || i==23) {
			return 3;
		}

		if(i==9 || i == 14 || i == 19 || i==24) {
			return 4;
		}

		if(i==10 || i == 15 || i == 20 || i==25) {
			return 5;
		}
		return i;
	}

	public int setValueDown(int i) {
		if(i<6){
			return 1;
		}

		if(i>=6 && i<=10) {
			return 2;
		}

		if(i>=11 && i<=15) {
			return 3;
		}
		if(i>=16 && i<=20) {
			return 4;
		}

		if(i>=21 && i<=25) {
			return 5;
		}
		return i;
	}
		
	}

