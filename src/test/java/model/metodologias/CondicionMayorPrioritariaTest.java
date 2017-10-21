package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.prioritarias.CondicionMayorPrioritaria;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.formas.de.aplicacion.FormaAplicacionEnum;

public class CondicionMayorPrioritariaTest extends CondicionTest {
	
	@Test
	public void condicionMayorPrioritariaConAplicacionSimpleTest() {
		CondicionPrioritaria condicionMayorPrioritaria =
				new CondicionMayorPrioritaria(indicador, FormaAplicacionEnum.APLICACION_SIMPLE, null, 1);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el valor de la Cuenta 1", condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorSumatoriaTest() {
		CondicionPrioritaria condicionMayorPrioritaria =
				new CondicionMayorPrioritaria(indicador, FormaAplicacionEnum.APLICACION_POR_SUMATORIA, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la sumatoria de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorPromedioTest() {
		CondicionPrioritaria condicionMayorPrioritaria =
				new CondicionMayorPrioritaria(indicador, FormaAplicacionEnum.APLICACION_POR_PROMEDIO, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorMedianaTest() {
		CondicionPrioritaria condicionMayorPrioritaria =
				new CondicionMayorPrioritaria(indicador, FormaAplicacionEnum.APLICACION_POR_MEDIANA, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por el promedio de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void condicionMayorPrioritariaConAplicacionPorConsistenciaTest() {
		CondicionPrioritaria condicionMayorPrioritaria =
				new CondicionMayorPrioritaria(indicador, FormaAplicacionEnum.APLICACION_POR_CONSISTENCIA, null, 3);
		Metodologia metodologia = new Metodologia("Ordena de mayor a menor por la consistencia de la Cuenta 1 en los ultimos 3 periodos",
				condicionMayorPrioritaria, null);
		
		assertEquals("Empresa 2", metodologia.evaluar(empresas).iterator().next().getName());
	}
}
