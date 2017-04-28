package model;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import window.VentanaPrincipal;


public class ProgramaDeHector extends Application {

	public static void main(String[] args) {		
		new ProgramaDeHector().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new VentanaPrincipal(this);
	}
}
