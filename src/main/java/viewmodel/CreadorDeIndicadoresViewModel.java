package viewmodel;

import org.uqbar.commons.utils.Observable;

import repositorios.RepositorioDeIndicadores;
import utils.File.InterpretadorDeIndicadores;

@Observable
public class CreadorDeIndicadoresViewModel {
	private String operacion;
	private String nombre;
	private InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();

	public void guardarIndicador() {
		RepositorioDeIndicadores.getInstance().registrarIndicador(interpretadorDeIndicadores.interpretar(nombre, operacion));
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
