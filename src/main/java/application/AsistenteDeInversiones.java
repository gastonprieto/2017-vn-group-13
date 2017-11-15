package application;

import spark.Spark;
import spark.debug.DebugScreen;

public class AsistenteDeInversiones {

	public static void main(String[] args) {		
		Spark.port(8080);
		DebugScreen.enableDebugScreen();
		Router.configure();
		TaskScheduler.scheduleTasks();
	}
}
