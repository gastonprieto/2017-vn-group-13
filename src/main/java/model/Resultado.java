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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"empresa_id", "indicador_id", "year", "semester"}))
public class Resultado {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 50)
	private Double valor;

	@Embedded
	private Periodo periodo;
	
	@ManyToOne
	@JoinColumn(name = "indicador_id")
	private Indicador indicador;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	public Resultado() {}		
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}
	
	public Indicador getIndicador() {
		return this.indicador;
	}	

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
