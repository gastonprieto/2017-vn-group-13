package model;

import java.util.Collection;

import exception.IndicadorException;
import org.uqbar.commons.utils.Observable;
import scala.xml.Null;

@Observable
public class Indicador {

	private String nombre;
	private Operando operacion;
	private Empresa empresaTarget;
	private Periodo periodoTarget;
	
	public Indicador(String nombre) {
		this.nombre = nombre;
	}
		
	public Double aplicar(Empresa empresa, Periodo periodo) {
		this.empresaTarget = empresa;
		this.periodoTarget = periodo;
		return operacion.resultado();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setOperacion(Operando operacion) {
		this.operacion = operacion;
	}

	public Double buscarValor(String nombre) {

		Double valor = this.empresaTarget.buscarValorDeCuentaParaPeriodo(nombre, this.periodoTarget);

		if (valor != null) {
			return valor;
		}
		
		try {
			valor = RepositorioDeIndicadores.getInstance().buscarIndicador(nombre).aplicar(empresaTarget, periodoTarget);			
		} catch (Exception e) {
			throw new IndicadorException("El indicador: " + nombre + ", no puede ser aplicado para la empresa: " + empresaTarget.getName()
			+ ", en el periodo: " + "A�o = " + periodoTarget.getYear() + " Semestre = " + periodoTarget.getSemester());
		}				
				
		return valor;
	}

	
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		return this.aplicar(empresa, periodos.iterator().next());
	}
}
