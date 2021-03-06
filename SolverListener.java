import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolverListener implements ActionListener {
	private PuzzleGame theGame;
	private Puzzle theFrame;

	public SolverListener(PuzzleGame g, Puzzle fr) {
		theGame = g;
		theFrame = fr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		theGame.solve();
		theFrame.solve();
	}
}