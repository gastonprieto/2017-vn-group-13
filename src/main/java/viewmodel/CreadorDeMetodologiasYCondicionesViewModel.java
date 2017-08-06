package viewmodel;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import model.*;
import org.uqbar.commons.utils.Observable;

import utils.InterpretadorDeIndicadores;
import utils.ManejadorDeArchivos;

@Observable
public class CreadorDeMetodologiasYCondicionesViewModel {	

	private String nombreMetodologia;
	private String nombreCondicion;
	private Indicador indicadorSeleccionado;
	private String tipoIndicadorSeleccionada; // es el calculo
	private String tipoCondicionSeleccionada;
	private String cantidadDePeriodos;
	private Double valorDeReferencia;
	private Collection<Condicion> condicionesCreadas = new ArrayList<Condicion>();
	private ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();



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

	/*-- CantidadDePeriodos   -- */
	public String getCantidadDePeriodos() {
		return cantidadDePeriodos;
	}
	public void setCantidadDePeriodos(String cantidadDePeriodos) {
		this.cantidadDePeriodos = cantidadDePeriodos;
	}

	/*-- ValorDeReferencia   -- */
	public Double getValorDeReferencia() {
		return valorDeReferencia;
	}
	public void setValorDeReferencia(Double valorDeReferencia) {
		this.valorDeReferencia = valorDeReferencia;
	}

	public String getTipoIndicadorSeleccionada() {
		return tipoIndicadorSeleccionada;
	}
	public Collection<String> getTiposIndicador(){
		Collection<String> tiposIndicadores = new ArrayList<>();
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
		tiposCondisiones.add("Creciente");
		tiposCondisiones.add("Decreciente");
		tiposCondisiones.add("Maximixar");
		
		return tiposCondisiones;
	}

	private Stream<String> getTiposPrioridad(){
		Collection<String> tiposPrioridad = new ArrayList<String>();
		tiposPrioridad.add("Creciente");
		tiposPrioridad.add("Decreciente");
		tiposPrioridad.add("Maximixar");
		return tiposPrioridad.stream();
	}

	private Stream<String> getTiposTaxativas(){
		Collection<String> tiposTaxativas = new ArrayList<String>();
		tiposTaxativas.add("Mayor");
		tiposTaxativas.add("Menor");
		return tiposTaxativas.stream();
	}

	/*--condicionesCreadas--*/
	public void setCondicionesCreadas(Collection<Condicion> condicionesCreadas) {
		this.condicionesCreadas = condicionesCreadas;
	}
	public Collection<Condicion> getCondicionesCreadas() {
		return condicionesCreadas;
	}

	/* --  FUNCIONES--*/
	public void AgregarCondicion(){
		FabricaCondicion fabrica;
		if(getTiposPrioridad().anyMatch(condicion -> condicion == tipoCondicionSeleccionada)) {
			fabrica = new FabricaCondicionesDePrioridad(nombreCondicion, indicadorSeleccionado, 10, tipoCondicionSeleccionada);
			condicionesCreadas.add(fabrica.ObtenerCondicion());
		}
		if(getTiposTaxativas().anyMatch(condicion -> condicion ==tipoCondicionSeleccionada)) {
			fabrica = new FabricaCondicionTaxativas(nombreCondicion, tipoIndicadorSeleccionada, indicadorSeleccionado, 10, tipoCondicionSeleccionada, 10.1);
			condicionesCreadas.add(fabrica.ObtenerCondicion());
		}


	}

	public void GuardarMetodologia(){
		RepositorioDeMetodologias.getInstance().registrarMetodologia(new Metodologia(nombreMetodologia, condicionesCreadas));			
		
		StringBuilder builderCondiciones = new StringBuilder();

		builderCondiciones.append(": ");
		for(Condicion condicion : condicionesCreadas) {			
			builderCondiciones.append(condicion.getInformacion());
			builderCondiciones.append("&");
		}
		
		builderCondiciones.toString();
		
		manejadorDeArchivos.escribirArchivo(System.getProperty("user.dir") + "/src/test/assets/Metodologias.csv",
				nombreMetodologia + builderCondiciones);
	}
}
