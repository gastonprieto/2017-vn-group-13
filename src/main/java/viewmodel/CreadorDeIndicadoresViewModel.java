package viewmodel;

import org.uqbar.commons.utils.Observable;

import model.RepositorioDeIndicadores;
import utils.InterpretadorDeIndicadores;
import utils.ManejadorDeArchivos;

@Observable
public class CreadorDeIndicadoresViewModel {

	private String operacion;
	private String nombre;
	private InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
	private ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
	
	public void guardarIndicador() {
		RepositorioDeIndicadores.getInstance().registrarIndicador(interpretadorDeIndicadores.interpretar(nombre, operacion));
		manejadorDeArchivos.escribirArchivo(System.getProperty("user.dir") + "/src/test/assets/Indicadores.csv",
				nombre + "," + operacion);
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
