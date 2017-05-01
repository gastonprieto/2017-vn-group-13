package application;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import window.VentanaPrincipal;


public class AsistenteDeInversiones extends Application {

	public static void main(String[] args) {		
		new AsistenteDeInversiones().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new VentanaPrincipal(this);
	}
}