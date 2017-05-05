package application;

import java.io.IOException;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import utils.ImportadorDeDatos;
import window.VentanaPrincipal;


public class AsistenteDeInversiones extends Application {

	public static void main(String[] args) throws IOException {		
		new AsistenteDeInversiones().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new VentanaPrincipal(this);
	}
}
