package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"empresa_id", "name", "year", "semester"}))
public class Cuenta {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private Double value;
	
	@Embedded
	private Periodo periodo;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false, insertable=true, updatable=true)
	private Empresa empresa;
	
	public Cuenta() {}
	
	public Cuenta(String name, Double value, Periodo periodo) {
		this.name = name;
		this.value = value;
		this.periodo = periodo;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Long getId() {
		return id;
	}
}
