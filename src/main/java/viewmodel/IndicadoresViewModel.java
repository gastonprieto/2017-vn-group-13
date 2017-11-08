package viewmodel;

import java.util.Collection;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import repositorios.RepositorioDeEmpresas;
import repositorios.RepositorioDeIndicadores;

@Observable
public class IndicadoresViewModel {
	private Indicador indicadorSeleccionado;
	private Empresa empresaSeleccionada;
	private int selectedYear;
	private int selectedSemester;
	private Double resultado;

	public Collection<Empresa> getEmpresas(){
		return RepositorioDeEmpresas.getInstance().getEmpresas();
	}

	public Collection<Indicador> getIndicadores() {
		return RepositorioDeIndicadores.getInstance().getIndicadores();
	}

	public void aplicarIndicador(){
		Periodo periodo = new Periodo(selectedYear, selectedSemester);
		resultado = indicadorSeleccionado.aplicar(empresaSeleccionada, periodo);
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}

	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public int getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
	}

	public int getSelectedSemester() {
		return selectedSemester;
	}

	public void setSelectedSemester(int selectedSemester) {
		this.selectedSemester = selectedSemester;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
}
