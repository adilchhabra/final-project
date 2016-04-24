import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetListener implements ActionListener {
	private PuzzleGame theGame;
	private Puzzle theFrame;

	public ResetListener(PuzzleGame g, Puzzle fr) {
		theGame = g;
		theFrame = fr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		theGame.reset();
		theFrame.reset();
	}
}