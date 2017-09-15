package viewmodel;

import java.util.ArrayList;
import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import Repositorio.RepositorioDeEmpresas;
import Repositorio.RepositorioDeMetodologias;
import model.Empresa;
import model.Metodologia;

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
