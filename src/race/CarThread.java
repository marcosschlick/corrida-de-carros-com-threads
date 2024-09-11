package race;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CarThread extends Thread {
	private Timer timer = new Timer();

	public CarThread(Car car, ArrayList<Car> cars, RaceScreen raceScreen) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (car.check(cars, raceScreen)) {
					car.move();

				} else {
					this.cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 50);

	}

}
