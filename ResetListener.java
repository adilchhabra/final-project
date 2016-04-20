import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetListener implements ActionListener {
	private KakurasuGame theGame;
	private KakurasuFrame theFrame;

	public ResetListener(KakurasuGame g, KakurasuFrame fr) {
		theGame = g;
		theFrame = fr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		theGame.reset();
		theFrame.reset();
	}
}