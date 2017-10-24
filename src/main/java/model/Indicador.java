package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.uqbar.commons.utils.Observable;
//import sun.security.util.Length;

import Parser.Operando;
import Repositorio.RepositorioDeEmpresas;
import Repositorio.RepositorioDeIndicadores;
import exception.EmpresaException;
import exception.IndicadorException;

@Entity
@Observable
public class Indicador {

	@Id
	@GeneratedValue
	private long id;

	@Column(length = 50, unique = true)
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
		try {
			return RepositorioDeEmpresas.getInstance().findCuentaByEmpresaAndPeriodoAndNombre(empresa, periodo, nombre).getValue();
		} catch (EmpresaException e) {
			try {
				return RepositorioDeIndicadores.getInstance().buscarIndicador(nombre).aplicar(empresa, periodo);
			} catch(IndicadorException e1) {
				throw new IndicadorException("No se pudo aplicar el indicador " + nombre + ". Motivo: " + e.getMessage());
			}
		}
	}
}
