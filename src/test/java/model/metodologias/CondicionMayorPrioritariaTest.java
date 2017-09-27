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
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionSimple, null, 1);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el valor de la Cuenta 1", condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorSumatoriaTest() {
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria();
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorSumatoria, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la sumatoria de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorPromedioTest() {
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio();
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorPromedio, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorMedianaTest() {
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana();
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorMediana, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorConsistenciaTest() {		
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia();
		CondicionPrioritaria condicionMayorPrioritaria = new CondicionMayorPrioritaria(indicador, aplicacionPorConsistencia, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la consistencia de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
}
