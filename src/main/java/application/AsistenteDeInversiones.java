package application;

import spark.Spark;

public class AsistenteDeInversiones {

	public static void main(String[] args) {		
		Spark.port(8080);
		Router.configure();
		TaskScheduler.scheduleTasks();
	}
}
