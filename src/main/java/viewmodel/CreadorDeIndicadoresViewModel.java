package viewmodel;

import model.Empresa;
import Repositorio.RepositorioDeEmpresas;
import org.uqbar.commons.utils.Observable;
import Repositorio.RepositorioDeIndicadores;
import utils.InterpretadorDeIndicadores;
import utils.ManejadorDeArchivos;
import java.util.Collection;

@Observable
public class CreadorDeIndicadoresViewModel {

	private String operacion;
	private String nombre;
	private InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
	private ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
	private Empresa empresaSeleccionada;

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

	public Collection<Empresa> getEmpresas(){
		return RepositorioDeEmpresas.getInstance().getEmpresas();
	}

	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {this.empresaSeleccionada = empresaSeleccionada;}

}
