package viewmodel;

import java.util.ArrayList;
import java.util.Collection;

import model.*;
import org.uqbar.commons.utils.Observable;

import utils.InterpretadorDeIndicadores;
import utils.ManejadorDeArchivos;

@Observable
public class CreadorDeMetodologiasYCondicionesViewModel {	

	private String nombreMetodologia;
	private String nombreCondicion;
	private Indicador indicadorSeleccionado;
	private String tipoIndicadorSeleccionada;
	private String tipoCondicionSeleccionada;
	private Collection<Condicion> condicionesCreadas;

	//private String indicadorSeleccionado;

	/*-- nombreMetodologia --*/
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}
	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}

	/*--nombreCondicion--*/
	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}
	public String getNombreCondicion() {
		return nombreCondicion;
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

	/*--condicionesCreadas--*/
	public void setCondicionesCreadas(Collection<Condicion> condicionesCreadas) {
		this.condicionesCreadas = condicionesCreadas;
	}
	public Collection<Condicion> getCondicionesCreadas() {
		return condicionesCreadas;
	}

	/* --  FUNCIONES --*/
	public void AgregarCondicion(){
		//condicionesCreadas.add()
	}
}
