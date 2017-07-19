package viewmodel;

import java.util.Collection;

import model.*;
import org.eclipse.core.internal.databinding.observable.masterdetail.DetailObservableList;
import org.uqbar.commons.utils.Observable;

@Observable
public class VerCuentasViewModel {
	private Indicador indicadorSeleccionado;
	private Empresa empresaSeleccionada;
	private  Periodo peridoSeleccionadao;
	private Double resultadoDeAplicarIndiador;
	
	public Collection<Empresa> getEmpresas(){
		return RepositorioDeEmpresas.getInstance().getEmpresas();
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {this.empresaSeleccionada = empresaSeleccionada;}

	public Collection<Indicador> getIndicadores(){ return RepositorioDeIndicadores.getInstance().getIndicadores();}

	public Indicador getindicadorSeleccionado() {return indicadorSeleccionado;	}

	public void setindicadorSeleccionado(Indicador _indicadorSeleccionado) {this.indicadorSeleccionado = _indicadorSeleccionado;}

	public Periodo getperidoSeleccionadao() {return peridoSeleccionadao;	}

	public void setperidoSeleccionadao(Periodo _peridoSeleccionadao) {this.peridoSeleccionadao = _peridoSeleccionadao;}

	public Double getresultadoDeAplicarIndiador() {return resultadoDeAplicarIndiador;	}

	public void setresultadoDeAplicarIndiador(Double _resultadoDeAplicarIndiador) {this.resultadoDeAplicarIndiador= _resultadoDeAplicarIndiador;}

	public void AplicarIndicadorEnPerido(){
		resultadoDeAplicarIndiador = indicadorSeleccionado.aplicar(empresaSeleccionada, peridoSeleccionadao);
	}



}