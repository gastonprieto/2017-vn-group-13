package model.condiciones.prioritarias;

import javax.persistence.Entity;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacionEnum;

@Entity
public class CondicionMayorPrioritaria extends CondicionPrioritaria {
	
	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacionEnum formaAplicacion,
			CondicionPrioritaria condicionDesempate, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
		this.cantPeriodos = cantPeriodos;
	}

	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacionEnum formaAplicacion, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.cantPeriodos = cantPeriodos;
	}

	@Override
	public int comparar(double resultadoEmpresa1, double resultadoEmpresa2) {
		// Devuelve un numero postivo si el primero es el menor, cero si son iguales y un numero negativo si el segundo es el menor
		return 0 - Double.compare(resultadoEmpresa1, resultadoEmpresa2);
	}
}
