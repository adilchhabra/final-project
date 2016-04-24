import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckerListener implements ActionListener {
	private PuzzleGame theGame;
	private Puzzle theFrame;

	public CheckerListener(PuzzleGame g, Puzzle fr) {
		theGame = g;
		theFrame = fr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(theGame.userCorrect()){
			theFrame.check();
		}
		if(!theGame.userCorrect()) {
			theFrame.checkFail();
		}
	}
}