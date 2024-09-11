package race;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WinnerLabel extends JLabel {

	public WinnerLabel(String name, Color color, int vertical) {
		setSize(500, 45);
		setFont(new Font("", Font.BOLD, 40));
		setText(name + " ganhou a corrida");
		setForeground(color);
		setLocation(100, vertical);

	}

}
