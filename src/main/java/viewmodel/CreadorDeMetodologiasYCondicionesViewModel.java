package viewmodel;

import java.nio.file.Files;
import java.nio.file.Paths;
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
	private Collection<Condicion> condicionesCreadas = new ArrayList<Condicion>();
	private ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();

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

	/* --  FUNCIONES--*/
	public void AgregarCondicion(){
	/*	if(tipoCondicionSeleccionada == "Mayor") {
			condicionesCreadas.add(new CondicionMayor(nombreCondicion,10, indicadorSeleccionado, );
		}
		if(tipoCondicionSeleccionada == "Menor"){
			condicionesCreadas.add(new CondicionMenor(nombreCondicion, 10, indicadorSeleccionado, new ConversorYearToPeriodos(10).Convertir()));
		}
		if(tipoCondicionSeleccionada == "Ascendente"){
			condicionesCreadas.add(new CondicionCreciente(nombreCondicion,indicadorSeleccionado, new ConversorYearToPeriodos(10).Convertir()));
		}
		if(tipoCondicionSeleccionada == "Descendente"){
			condicionesCreadas.add(new CondicionDecreciente(nombreCondicion,indicadorSeleccionado, new ConversorYearToPeriodos(10).Convertir()));
		}*/
		
		FabricaCondicionesDePrioridad fabrica = new FabricaCondicionesDePrioridad(nombreCondicion, indicadorSeleccionado, 10, tipoCondicionSeleccionada);
		condicionesCreadas.add(fabrica.ObtenerCondicion());
				
	}

	public void GuardarMetodologia(){
		RepositorioDeMetodologias.getInstance().registrarMetodologia(new Metodologia(nombreMetodologia, condicionesCreadas));
		
		StringBuilder builderCondiciones = new StringBuilder();
		
	/*	for(Condicion condicion : condicionesCreadas) {
			builderCondiciones.append(",");
			builderCondiciones.append(condicion.getName());
			builderCondiciones.append(",");
			builderCondiciones.append(condicion.getIndicador().getNombre());			
		}
		
		builderCondiciones.toString();
		
		manejadorDeArchivos.escribirArchivo(System.getProperty("user.dir") + "/src/test/assets/Metodologias.csv",
				nombreMetodologia + "," + builderCondiciones);*/
	}
}
