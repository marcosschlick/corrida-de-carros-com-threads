package race;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Race {

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<>();
		ArrayList<Thread> threads = new ArrayList<>();
		Color[] colors = { Color.cyan, Color.green, Color.MAGENTA, Color.darkGray, Color.YELLOW, Color.blue, Color.red,
				Color.WHITE };
		Timer timer = new Timer();
		RaceScreen screen = new RaceScreen();

		createCars(cars, colors);

		cars.forEach(car -> screen.addCar(car));

		createThreads(cars, threads, timer,screen);

		threads.forEach(thread -> thread.start());

	}

	private static void createCars(ArrayList<Car> cars, Color[] colors) {
		int vertical = 100;

		for (int i = 0; i < colors.length; i++) {
			cars.add(new Car("Carro " + (i + 1), colors[i], vertical));
			vertical += 80;
		}
	}

	private static void createThreads(ArrayList<Car> carros, ArrayList<Thread> threads, Timer timer, RaceScreen screen) {
		for (Car carro : carros) {
			threads.add(new Thread(() -> {
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						if (carro.check(carros, screen)) {
							carro.move();

						} else {
							this.cancel();
						}
					}
				};
				timer.scheduleAtFixedRate(task, 0, 50);
			}));
		}
	}
}
