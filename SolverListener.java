import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolverListener implements ActionListener {
	private KakurasuGame theGame;
	private KakurasuFrame theFrame;

	public SolverListener(KakurasuGame g, KakurasuFrame fr) {
		theGame = g;
		theFrame = fr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You can solve!");
		theGame.solve();
		//theFrame.solve();
	}
}