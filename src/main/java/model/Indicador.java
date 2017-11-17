package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import exception.EmpresaException;
import exception.IndicadorException;
import parser.Operando;
import repositorios.RepositorioDeEmpresas;
import repositorios.RepositorioDeIndicadores;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "nombre"}))
public class Indicador {

	@Id
	@GeneratedValue
	private long id;

	@Column(length = 50, unique = true)
	private String nombre;

	@Transient
	private Operando operacion;

	@Column(length = 100)
	private String operacionPersistencia;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public Indicador(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	
	public Indicador() {
		
	}

	public Double aplicar(Empresa empresa, Periodo periodo, Usuario usuario) {
		return operacion.resultado(empresa, periodo, usuario);
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
	
	public String getOperacionPersistencia() {
		return operacionPersistencia;
	}

	public Double buscarValor(String nombre, Empresa empresa, Periodo periodo, Usuario usuario) {
		try {
			return RepositorioDeEmpresas.getInstance().findCuentaByEmpresaAndPeriodoAndNombre(empresa, periodo, nombre).getValue();
		} catch (EmpresaException e) {
			try {
				return RepositorioDeIndicadores.getInstance().buscarIndicador(nombre, usuario).aplicar(empresa, periodo, usuario);
			} catch(IndicadorException e1) {
				throw new IndicadorException("No se pudo aplicar el indicador " + nombre + ". Motivo: " + e.getMessage());
			}
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
