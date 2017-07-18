package viewmodel;

import java.util.Collection;

import model.*;
import org.uqbar.commons.utils.Observable;

@Observable
public class VerCuentasViewModel {
	private Indicador indicadorSeleccionado;

	private Empresa empresaSeleccionada;


	private Periodo peridosDisponibles;
	
	public Collection<Empresa> getEmpresas(){
		return RepositorioDeEmpresas.getInstance().getEmpresas();
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {this.empresaSeleccionada = empresaSeleccionada;}



	public Collection<Indicador> getIndicadores(){ return RepositorioDeIndicadores.getInstance().getIndicadores();}

	public Indicador getindicadorSeleccionado() {return indicadorSeleccionado;	}

	public void setindicadorSeleccionado(Indicador indicadorSeleccionado) {this.indicadorSeleccionado = indicadorSeleccionado;}

}