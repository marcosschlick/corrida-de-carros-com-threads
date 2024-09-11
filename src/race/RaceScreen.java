package race;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RaceScreen extends JFrame {

	private JPanel contentPane;

	public RaceScreen() {
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

	public void addCar(Car car) {
		contentPane.add(car);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void addLabel(WinnerLabel label) {
		contentPane.add(label);
		contentPane.revalidate();
		contentPane.repaint();
	}
}
