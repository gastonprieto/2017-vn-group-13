package viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.uqbar.commons.utils.Observable;

import Repositorio.RepositorioDeIndicadores;
import Repositorio.RepositorioDeMetodologias;
import exception.BuilderException;
import model.Indicador;
import model.builders.MetodologiaBuilder;
import model.condiciones.prioritarias.CondicionMayorPrioritaria;
import model.condiciones.prioritarias.CondicionMenorPrioritaria;
import model.condiciones.taxativas.CondicionCrecienteTaxativa;
import model.condiciones.taxativas.CondicionDecrecienteTaxativa;
import model.condiciones.taxativas.CondicionMayorTaxativa;
import model.condiciones.taxativas.CondicionMenorTaxativa;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionPorMediana;
import model.formas.de.aplicacion.AplicacionPorPromedio;
import model.formas.de.aplicacion.AplicacionPorSumatoria;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;

@Observable
public class CrearCondicionViewModel {
	
	private MetodologiaBuilder builder;
	private int cantPeriodos = 0;
	private List<String> tiposDeCondicion;
	private String tipoDeCondicionSeleccionada;
	private Indicador indicadorSeleccionado;
	private List<String> formasDeAplicacion;
	private String formaDeAplicacionSeleccionada;
	private double valorDeReferencia = 0;

	public CrearCondicionViewModel() {
		this.tiposDeCondicion = new ArrayList<>();
		this.tiposDeCondicion.add("Mayor Taxativa");
		this.tiposDeCondicion.add("Menor Taxativa");
		this.tiposDeCondicion.add("Creciente");
		this.tiposDeCondicion.add("Decreciente");
		this.tiposDeCondicion.add("Mayor Prioritaria");
		this.tiposDeCondicion.add("Menor Prioritaria");
		
		this.formasDeAplicacion = new ArrayList<>();
		this.formasDeAplicacion.add("Simple");
		this.formasDeAplicacion.add("Por Sumatoria");
		this.formasDeAplicacion.add("Por Promedio");
		this.formasDeAplicacion.add("Por Mediana");
		this.formasDeAplicacion.add("Por Consistencia");
	}
	
	public MetodologiaBuilder getBuilder() {
		this.validarParametros();
		this.crearCondicion();
		return this.builder;
	}

	private void crearCondicion() {
		if(StringUtils.equals(tipoDeCondicionSeleccionada, "Mayor Prioritaria")) {
			this.builder.agregarCondicionPrioritaria(new CondicionMayorPrioritaria(indicadorSeleccionado, this.crearFormaAplicacion()));
		} else if(StringUtils.equals(tipoDeCondicionSeleccionada, "Menor Prioritaria")) {
			this.builder.agregarCondicionPrioritaria(new CondicionMenorPrioritaria(indicadorSeleccionado, this.crearFormaAplicacion()));
		} else if(StringUtils.equals(tipoDeCondicionSeleccionada, "Mayor Taxativa")) {
			this.builder.agregarCondicionTaxativa(new CondicionMayorTaxativa(indicadorSeleccionado,
					this.crearFormaAplicacion(),this.valorDeReferencia));
		} else if(StringUtils.equals(tipoDeCondicionSeleccionada, "Menor Taxativa")) {
			this.builder.agregarCondicionTaxativa(new CondicionMenorTaxativa(indicadorSeleccionado,
					this.crearFormaAplicacion(),this.valorDeReferencia));
		} else if(StringUtils.equals(tipoDeCondicionSeleccionada, "Creciente")) {
			this.builder.agregarCondicionTaxativa(new CondicionCrecienteTaxativa(indicadorSeleccionado, this.cantPeriodos));
		} else {
			this.builder.agregarCondicionTaxativa(new CondicionDecrecienteTaxativa(indicadorSeleccionado, this.cantPeriodos));
		}
	}

	private FormaAplicacion crearFormaAplicacion() {
		if(StringUtils.equals(formaDeAplicacionSeleccionada, "Simple")) {
			return new AplicacionSimple();
		} else if(StringUtils.equals(formaDeAplicacionSeleccionada, "Por Sumatoria")) {
			return new AplicacionPorSumatoria(cantPeriodos);
		} else if(StringUtils.equals(formaDeAplicacionSeleccionada, "Por Promedio")) {
			return new AplicacionPorPromedio(cantPeriodos);
		} else if(StringUtils.equals(formaDeAplicacionSeleccionada, "Por Mediana")) {
			return new AplicacionPorMediana(cantPeriodos);
		} else {
			return new AplicacionPorConsistencia(cantPeriodos);
		}
	}

	private void validarParametros() {
		if(StringUtils.isEmpty(tipoDeCondicionSeleccionada)) {
			throw new BuilderException("Debe seleccionar un tipo de condicion");
		} else if(indicadorSeleccionado == null) {
			throw new BuilderException("Debe seleccionar un indicador");
		} else if(StringUtils.isEmpty(formaDeAplicacionSeleccionada) 
				&& !StringUtils.equals(tipoDeCondicionSeleccionada, "Creciente")
				&& !StringUtils.equals(tipoDeCondicionSeleccionada, "Decreciente")) {
			throw new BuilderException("Debe seleccionar una forma de aplicacion");
		} else if(cantPeriodos <= 0 && !StringUtils.equals(formaDeAplicacionSeleccionada, "Simple")) {
			throw new BuilderException("La cantidad de periodos debe ser superior a 0");
		}
	}

	public void crearMetodologia() {
		this.validarParametros();
		this.crearCondicion();
		RepositorioDeMetodologias.getInstance().registrarMetodologia(builder.build());
	}

	public int getCantPeriodos() {
		return cantPeriodos;
	}

	public void setCantPeriodos(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}

	public List<String> getTiposDeCondicion() {
		return tiposDeCondicion;
	}

	public String getTipoDeCondicionSeleccionada() {
		return tipoDeCondicionSeleccionada;
	}

	public void setTipoDeCondicionSeleccionada(String tipoDeCondicionSeleccionada) {
		this.tipoDeCondicionSeleccionada = tipoDeCondicionSeleccionada;
	}
	
	public Collection<Indicador> getIndicadores() {
		return RepositorioDeIndicadores.getInstance().getIndicadores();
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}
	
	public List<String> getFormasDeAplicacion() {
		return formasDeAplicacion;
	}

	public String getFormaDeAplicacionSeleccionada() {
		return formaDeAplicacionSeleccionada;
	}

	public void setFormaDeAplicacionSeleccionada(String formaDeAplicacionSeleccionada) {
		this.formaDeAplicacionSeleccionada = formaDeAplicacionSeleccionada;
	}
	
	public double getValorDeReferencia() {
		return valorDeReferencia;
	}

	public void setValorDeReferencia(double valorDeReferencia) {
		this.valorDeReferencia = valorDeReferencia;
	}

	public void setBuilder(MetodologiaBuilder builder) {
		this.builder = builder;
	}
}
