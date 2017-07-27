package viewmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import model.Indicador;
import model.RepositorioDeEmpresas;
import model.RepositorioDeIndicadores;
import utils.InterpretadorDeIndicadores;
import utils.ManejadorDeArchivos;

@Observable
public class CreadorDeMetodologiasYCondicionesViewModel {	

	private String nombreMetodologia;
	private Indicador indicadorSeleccionado;
	private String tipoIndicadorSeleccionada;
	private String tipoCondicionSeleccionada;

	//private String indicadorSeleccionado;

	/*-- nombreMetodologia --*/
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}
	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}

	/*-- indicadorSelecciondao --*/
	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}
	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}
	public Collection<Indicador> getIndicadores(){
		return RepositorioDeIndicadores.getInstance().getIndicadores();
	}

	/*--tipoIndicadorSeleccionada--*/
	public void setTipoIndicadorSeleccionada(String tipoIndicadorSeleccionada) {
		this.tipoIndicadorSeleccionada = tipoIndicadorSeleccionada;
	}
	public String getTipoIndicadorSeleccionada() {
		return tipoIndicadorSeleccionada;
	}
	public Collection<String> getTiposIndicador(){
		Collection<String> tiposIndicadores = new ArrayList<>();
		tiposIndicadores.add("Simple");
		tiposIndicadores.add("Promedio");
		tiposIndicadores.add("Sumatoria");
		tiposIndicadores.add("Media");

		return tiposIndicadores;
	}

	/*-- tipoCondicionSeleccionada--*/
	public String getTipoCondicionSeleccionada() {
		return tipoCondicionSeleccionada;
	}
	public void setTipoCondicionSeleccionada(String tipoCondicionSeleccionada) {
		this.tipoCondicionSeleccionada = tipoCondicionSeleccionada;
	}
	public Collection<String> getTipos(){
		Collection<String> tiposCondisiones = new ArrayList<>();
		tiposCondisiones.add("Mayor");
		tiposCondisiones.add("Menor");
		tiposCondisiones.add("Ascendente");
		tiposCondisiones.add("Descendente");
		
		return tiposCondisiones;
	}






}
