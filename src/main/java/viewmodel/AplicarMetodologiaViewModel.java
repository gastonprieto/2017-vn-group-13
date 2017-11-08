package viewmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import model.Metodologia;
import repositorios.RepositorioDeEmpresas;
import repositorios.RepositorioDeMetodologias;

@Observable
public class AplicarMetodologiaViewModel {

	private Metodologia metodologiaSeleccionada;
	private Collection<Empresa> resultadoEmpresasEvaluadas = new ArrayList<>();
	
	public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}
	
	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}
	
	public Collection<Metodologia> getMetodologias(){
		return RepositorioDeMetodologias.getInstance().getMetodologias();
		//return new ArrayList<Metodologia>();
	}
	
	public Collection<Empresa> getResultadoEmpresasEvaluadas() {
		return resultadoEmpresasEvaluadas;
	}
	
	public void setResultadoEmpresasEvaluadas(Collection<Empresa> resultadoEmpresasEvaluadas) {
		this.resultadoEmpresasEvaluadas = resultadoEmpresasEvaluadas;
	}
	
	public void aplicarMetodologiaSeleccionada(){
		resultadoEmpresasEvaluadas = metodologiaSeleccionada.evaluar(RepositorioDeEmpresas.getInstance().getEmpresas());
	}
}
