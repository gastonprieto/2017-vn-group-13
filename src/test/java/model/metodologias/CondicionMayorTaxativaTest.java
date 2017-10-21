package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.taxativas.CondicionMayorTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.FormaAplicacionEnum;

public class CondicionMayorTaxativaTest extends CondicionTest {

	@Test
	public void condicionMayorTaxativaConAplicacionSimpleTest() {
		CondicionTaxativa condicionMayorTaxativa =
				new CondicionMayorTaxativa(indicador, FormaAplicacionEnum.APLICACION_SIMPLE, null, 2, 1);
		Metodologia metodologia = new Metodologia("Cuenta 1 mayor a 2 en el ultimo periodo", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorSumatoriaTest() {
		CondicionTaxativa condicionMayorTaxativa =
				new CondicionMayorTaxativa(indicador, FormaAplicacionEnum.APLICACION_POR_SUMATORIA, null, 7, 3);
		Metodologia metodologia = new Metodologia("Sumatoria en los ultimos 3 periodos de la Cuenta 1 mayor a 7", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorPromedioTest() {
		CondicionTaxativa condicionMayorTaxativa = 
				new CondicionMayorTaxativa(indicador, FormaAplicacionEnum.APLICACION_POR_PROMEDIO, null, 2, 3);
		Metodologia metodologia = new Metodologia("Promedio de los ultimos 3 periodos de la Cuenta 1 mayor a 2", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorMedianaTest() {
		CondicionTaxativa condicionMayorTaxativa =
				new CondicionMayorTaxativa(indicador, FormaAplicacionEnum.APLICACION_POR_MEDIANA, null, 2, 3);
		Metodologia metodologia = new Metodologia("Mediana de los ultimos 3 periodos de la Cuenta 1 mayor a 2", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorConsistenciaTest() {
		CondicionTaxativa condicionMayorTaxativa =
				new CondicionMayorTaxativa(indicador, FormaAplicacionEnum.APLICACION_POR_CONSISTENCIA, null, 0.5, 3);
		Metodologia metodologia = new Metodologia("Cuenta 1 mayor a 0.5 en los ultimos 3 periodos", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
