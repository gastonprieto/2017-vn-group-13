package viewmodel;

import java.time.Year;
import java.util.Collection;

import model.*;
import org.eclipse.core.internal.databinding.observable.masterdetail.DetailObservableList;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.model.UserException;

@Observable
public class VerCuentasViewModel {
	private Indicador indicadorSeleccionado;
	private Empresa empresaSeleccionada;
	private int yearSeleccionado;
	private int semestreSeleccionado;
	private Double resultadoDeAplicarIndiador;

	public Collection<Empresa> getEmpresas(){
		return RepositorioDeEmpresas.getInstance().getEmpresas();
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {this.empresaSeleccionada = empresaSeleccionada;}

	public Collection<Indicador> getIndicadores(){ return RepositorioDeIndicadores.getInstance().getIndicadores();}

	public Indicador getIndicadorSeleccionado() {return indicadorSeleccionado;	}

	public void setIndicadorSeleccionado(Indicador _indicadorSeleccionado) {this.indicadorSeleccionado = _indicadorSeleccionado;}

	public Double getResultadoDeAplicarIndiador() {return resultadoDeAplicarIndiador;	}

	public void setResultadoDeAplicarIndiador(Double _resultadoDeAplicarIndiador) {this.resultadoDeAplicarIndiador= _resultadoDeAplicarIndiador;}

	public void setSemestreSeleccionado(int semestreSeleccionado) {
		this.semestreSeleccionado = semestreSeleccionado;
	}

	public int getSemestreSeleccionado() {
		return semestreSeleccionado;
	}

	public void setYearSeleccionado(int yearSeleccionado) {
		this.yearSeleccionado = yearSeleccionado;
	}

	public int getYearSeleccionado() {
		return yearSeleccionado;
	}

	public void AplicarIndicadorEnPerido(){
		Periodo periodoSeecionado = new Periodo(yearSeleccionado, semestreSeleccionado);
		try {
			resultadoDeAplicarIndiador = indicadorSeleccionado.aplicar(empresaSeleccionada, periodoSeecionado);
		}catch (UserException e){
			resultadoDeAplicarIndiador = 0.01;
		}
	}



}