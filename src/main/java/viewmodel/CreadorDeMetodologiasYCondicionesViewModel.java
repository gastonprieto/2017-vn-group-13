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
	private Indicador indicadorSeleccionado;
	
	public Collection<String> getTipos(){
		Collection<String> tiposCondisiones = new ArrayList<>();
		tiposCondisiones.add("Filtro");
		tiposCondisiones.add("Orden");
		
		return tiposCondisiones;
	}
	
	public String getTipoCondicionSeleccionado() {
		return tipoCondicionSeleccionado;
	}
	
	public void setTipoCondicionSeleccionado(String valor) {
        this.tipoCondicionSeleccionado = valor;
    }
	
	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}
	
	public Collection<Indicador> getIndicadores(){
		return RepositorioDeIndicadores.getInstance().getIndicadores();
	}		
}
