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

	@Transient
	private Empresa empresaTarget;

	@Transient
	private Periodo periodoTarget;

	public Indicador(String nombre) {
		this.nombre = nombre;
	}
		
	public Double aplicar(Empresa empresa, Periodo periodo) {
		this.empresaTarget = empresa;
		this.periodoTarget = periodo;
		return operacion.resultado();
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

	public Double buscarValor(String nombre) {
		Double valor = null;

		try {
			valor = this.empresaTarget.buscarValorDeCuentaParaPeriodo(nombre, this.periodoTarget);
		} catch (EmpresaException e) {
			throw new IndicadorException("El indicador: " + nombre + ", no puede ser aplicado ya que " + e.getMessage());
		}		

		if (valor != null) {
			return valor;
		}
		/*porque aca no puede ir un this.aplicar? o alago asi*/
		valor = RepositorioDeIndicadores.getInstance().buscarIndicador(nombre).aplicar(this.empresaTarget, this.periodoTarget);
		if (valor != null) {
			return valor;
		}
		throw new IndicadorException("El indicador: " + nombre + ", no puede ser aplicado para la empresa: " + this.empresaTarget.getName()
				+ ", en el periodo: " + "A�o = " + this.periodoTarget.getYear() + " Semestre = " + this.periodoTarget.getSemester());
	}

	
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		return this.aplicar(empresa, periodos.iterator().next());
	}
}
