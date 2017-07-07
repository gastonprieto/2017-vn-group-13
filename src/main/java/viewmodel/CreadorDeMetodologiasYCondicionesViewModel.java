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
	
	private String tipoCondicionSeleccionado;
	private String tipoIndicadorSeleccionado;
	private String indicadorSeleccionado;

	
	public Collection<String> getTipos(){
		Collection<String> tiposCondisiones = new ArrayList<>();
		tiposCondisiones.add("Mayor");
		tiposCondisiones.add("Menor");
		tiposCondisiones.add("Ascendente");
		tiposCondisiones.add("Descendente");
		
		return tiposCondisiones;
	}

	public Collection<String> getTiposIndicador(){
		Collection<String> tiposIndicadores = new ArrayList<>();
		tiposIndicadores.add("Simple");
		tiposIndicadores.add("Promedio");
		tiposIndicadores.add("Sumatoria");
		tiposIndicadores.add("Media");

		return tiposIndicadores;
	}
	
	public String getTipoCondicionSeleccionado() {
		return tipoCondicionSeleccionado;
	}
	
	public void setTipoCondicionSeleccionado(String valor) {
        this.tipoCondicionSeleccionado = valor;
    }
	
	public String getTipoIndicadorSeleccionado() {
		return tipoIndicadorSeleccionado;
	}

	public String getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(String indicador) {
		this.tipoIndicadorSeleccionado = indicador;
	}
	
	public Collection<Indicador> getIndicadores(){
		return RepositorioDeIndicadores.getInstance().getIndicadores();
	}		
}
