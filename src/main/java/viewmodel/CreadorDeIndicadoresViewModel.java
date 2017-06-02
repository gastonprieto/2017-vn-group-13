package viewmodel;

import utils.ImportadorDeDatos;
import utils.InterpretadorDeIndicadores;

public class CreadorDeIndicadoresViewModel {

	private String operacion;
	private String nombre;
	InterpretadorDeIndicadores interprete = new InterpretadorDeIndicadores();
	
	
	public void guardarIndicador() {
		//interprete.
	}
	
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
