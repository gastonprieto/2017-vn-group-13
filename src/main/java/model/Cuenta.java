package model;

import org.uqbar.commons.utils.Observable;

import javax.persistence.*;

@Entity
@Observable
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
	@JoinColumn(name = "empresa_id")
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!Cuenta.class.isAssignableFrom(obj.getClass()))
			return false;
		final Cuenta cuentaAComparar = (Cuenta) obj;
		if (!this.name.equals(cuentaAComparar.name) 
				|| !this.value.equals(cuentaAComparar.value) 
				|| !this.periodo.equals(cuentaAComparar.periodo))
			return false;				
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);		
		return hash;
	}
}
