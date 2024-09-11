package race;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;

public class Race {

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<>();
		ArrayList<Thread> threads = new ArrayList<>();
		Color[] colors = { Color.cyan, Color.green, Color.MAGENTA, Color.darkGray, Color.YELLOW, Color.blue, Color.red,
				Color.WHITE };
		Timer timer = new Timer();
		RaceScreen raceScreen = new RaceScreen();

		createCars(cars, colors);

		cars.forEach(car -> raceScreen.addCar(car));

		createThreads(cars, threads, timer, raceScreen);

	}

	private static void createCars(ArrayList<Car> cars, Color[] colors) {
		int vertical = 100;

		for (int i = 0; i < colors.length; i++) {
			cars.add(new Car("Carro " + (i + 1), colors[i], vertical));
			vertical += 80;
		}
	}

	private static void createThreads(ArrayList<Car> cars, ArrayList<Thread> threads, Timer timer,
			RaceScreen raceScreen) {
		for (Car car : cars) {
			threads.add(new CarThread(car, cars, raceScreen));
		}
	}
}
