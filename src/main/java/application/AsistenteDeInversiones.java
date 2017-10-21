package application;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import spark.Spark;
import spark.debug.DebugScreen;
import window.MenuView;

public class AsistenteDeInversiones extends Application {

	public static void main(String[] args) {		
		new AsistenteDeInversiones().start();
		//Spark.port(8080);
		//DebugScreen.enableDebugScreen();
		//Router.configure();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new MenuView(this, true);
	}
}
