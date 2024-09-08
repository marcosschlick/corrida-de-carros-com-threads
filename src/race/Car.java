package race;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Car extends JPanel {
	private String name;
	private int speed = 5;
	private ImageIcon image;

	public Car(String name, Color color, int vertical) {
		this.image = new ImageIcon(
				"C:\\Users\\marcos\\eclipse-workspaces\\eclipse-workspace\\corrida-de-carros-com-threads\\src\\race/car.png");
		this.name = name;
		setLocation(20, vertical);
		setBackground(color);
		setVisible(true);
		setBounds(20, vertical, image.getIconWidth(), image.getIconHeight());
	}

	public void addTurbo() {
		setSpeed(10);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				setSpeed(5);
			}
		};
		timer.schedule(task, 100);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return this.name;
	}

	public void move() {
		this.setLocation(this.getX() + this.speed, this.getY());
		repaint(); 
		double turbo = Math.random() * 10;
		if (turbo > 9.5) {
			addTurbo();
		}
	}

	public boolean check(ArrayList<Car> carros, RaceScreen screen) {
		Predicate<Car> limite = c -> c.getX() >= 650;
		if (carros.stream().anyMatch(limite)) {
			if (this.getX() >= 650) {

				screen.addLabel(new WinnerLabel(this.getName(), this.getBackground(), this.getY()));

			}
			return false; 
		} else {
			return true;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, this);
	}
}
