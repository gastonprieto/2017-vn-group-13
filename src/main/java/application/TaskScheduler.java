package application;

import java.util.Calendar;
import java.util.Timer;

import utils.ImportadorDeDatos;

public class TaskScheduler {

	public static void scheduleTasks() {
		Timer timer = new Timer();
		ImportadorDeDatos importador = new ImportadorDeDatos();
		Calendar time = Calendar.getInstance();
		time.set(Calendar.DAY_OF_MONTH, time.get(Calendar.DAY_OF_MONTH));
		time.set(Calendar.HOUR_OF_DAY, 0);
		time.set(Calendar.MINUTE, 0);
		// La importacion corre a las 00:00 todos los dias
		timer.schedule(importador, time.getTime(), 86400000);
	}
}
