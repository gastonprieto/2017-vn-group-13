package viewmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.Condicion;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.RepositorioDeEmpresas;
import model.RepositorioDeIndicadores;
import model.RepositorioDeMetodologias;
import utils.InterpretadorDeIndicadores;
import utils.ManejadorDeArchivos;

@Observable
public class CreadorDeMetodologiasViewModel {	
	
	private String tipoCondicionSeleccionado;
	private String modoCondicionSeleccionado;
	private Indicador indicadorSeleccionado;
	private Double periodoSeleccionado;
	private Condicion condicion;
	
	public Collection<String> getTipos(){
		Collection<String> tiposCondiciones = new ArrayList<>();
		tiposCondiciones.add("Mayor a");
		tiposCondiciones.add("Menor a");
		tiposCondiciones.add("Orden ascendiente");
		tiposCondiciones.add("Orden descendiente");
		return tiposCondiciones;
	}
	
	public Collection<String> getModo(){
		Collection<String> modoCondiciones = new ArrayList<>();
		modoCondiciones.add("Indicador");
		modoCondiciones.add("Media");
		modoCondiciones.add("Promedio");
		modoCondiciones.add("Sumatoria");
		return modoCondiciones;
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
	public void setIndicadorSeleccionado(Indicador indicador) {
		this.indicadorSeleccionado = indicador;
	}
	public Collection<Indicador> getIndicadores(){
		return RepositorioDeIndicadores.getInstance().getIndicadores();
	}

	/*  public Collection<Metodologia> getMetodologias() {
	    return RepositorioDeMetodologias.getInstance().getMetodologias();
	}
	*/
	public void setMetodologia(){
		
		//Collection<Condicion> condiciones= new Arraylist<>();
		
		//Metodologia metodologia = new Metodologia("nombre",condiciones);
		
		//RepositorioDeMetodologias.getInstance().registrarMetodologia(metodologia);
		
	}
	  
	public Double getPeriodoSeleccionado() {
		return periodoSeleccionado;
	}

	public void setPeriodoSeleccionado(Double periodoSeleccionado) {
		this.periodoSeleccionado = periodoSeleccionado;
	}

	public String getModoCondicionSeleccionado() {
		return modoCondicionSeleccionado ;
	}
	
	public void setModoCondicionSeleccionado(String modoCondicionSeleccionado) {
		this.modoCondicionSeleccionado = modoCondicionSeleccionado;
	}
	 public void getCondicion(){
		 
	 }

}

