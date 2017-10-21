package model;

import java.util.Collection;

import Parser.Operando;
import Repositorio.RepositorioDeIndicadores;
import exception.EmpresaException;
import exception.IndicadorException;
import org.uqbar.commons.utils.Observable;
//import sun.security.util.Length;

import javax.persistence.*;

@Entity
@Observable
public class Indicador {

	@Id
	@GeneratedValue
	private long id;

	@Column(length = 50)
	public String nombre;

	@Transient
	private Operando operacion;

	@Column(length = 100)
	private String operacionPersistencia;

	public Indicador(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	
	public Indicador() {}
		
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return operacion.resultado(empresa, periodo);
	}

	public Indicador(String nombre, String OperacionPersistir){
		this.nombre = nombre;
		this.operacionPersistencia = OperacionPersistir;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setOperacion(Operando operacion) {
		this.operacion = operacion;
	}

	public Double buscarValor(String nombre, Empresa empresa, Periodo periodo) {
		Double valor = null;
		try {
			valor = empresa.buscarValorDeCuentaParaPeriodo(nombre, periodo);
		} catch (EmpresaException e) {
			throw new IndicadorException("El indicador: " + nombre + ", no puede ser aplicado ya que " + e.getMessage());
		}		
		if (valor != null) {
			return valor;
		}
		valor = RepositorioDeIndicadores.getInstance().buscarIndicador(nombre).aplicar(empresa, periodo);
		if (valor != null) {
			return valor;
		}
		throw new IndicadorException("El indicador: " + nombre + ", no puede ser aplicado para la empresa: " + empresa.getName()
				+ ", en el periodo: " + "A�o = " + periodo.getYear() + " Semestre = " + periodo.getSemester());
	}

	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		return this.aplicar(empresa, periodos.iterator().next());
	}
}
