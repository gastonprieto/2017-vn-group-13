package model.condiciones.prioritarias;

import model.Indicador;
import model.formas.de.aplicacion.AplicacionForma;
import model.formas.de.aplicacion.FormaAplicacion;

import java.util.concurrent.CancellationException;

import javax.persistence.Entity;

@Entity
public class CondicionMayorPrioritaria extends CondicionPrioritaria {
	
	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, CondicionPrioritaria condicionDesempate, int cantPeriodos,
			AplicacionForma aplicacionForma) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.condicionDesempate = condicionDesempate;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = aplicacionForma;
	}

	public CondicionMayorPrioritaria(Indicador indicador, FormaAplicacion formaAplicacion, int cantPeriodos,
			AplicacionForma aplicacionForma) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = aplicacionForma;
	}

	@Override
	public int comparar(double resultadoEmpresa1, double resultadoEmpresa2) {
		// Devuelve un numero postivo si el primero es el menor, cero si son iguales y un numero negativo si el segundo es el menor
		return 0 - Double.compare(resultadoEmpresa1, resultadoEmpresa2);
	}
}
