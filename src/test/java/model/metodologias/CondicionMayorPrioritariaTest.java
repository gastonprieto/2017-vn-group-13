package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.prioritarias.CondicionMayorPrioritaria;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionPorMediana;
import model.formas.de.aplicacion.AplicacionPorPromedio;
import model.formas.de.aplicacion.AplicacionPorSumatoria;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;

public class CondicionMayorPrioritariaTest extends CondicionTest {
	
	@Test
	public void condicionMayorPrioritariaConAplicacionSimpleTest() {
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionSimple, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el valor de la Cuenta 1", condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorSumatoriaTest() {
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria(3);
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorSumatoria, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la sumatoria de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorPromedioTest() {
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio(3);
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorPromedio, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorMedianaTest() {
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana(3);
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorMediana, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).get(0).getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorConsistenciaTest() {		
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia(3);
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorConsistencia, null);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la consistencia de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).get(0).getName());
	}
}
