package viewmodel;


import java.util.Collection;
import model.*;
import org.uqbar.commons.utils.Observable;


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
		resultadoDeAplicarIndiador = indicadorSeleccionado.aplicar(empresaSeleccionada, periodoSeecionado);
	}



}