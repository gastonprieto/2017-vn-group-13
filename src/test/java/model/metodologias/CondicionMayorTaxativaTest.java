package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Metodologia;
import model.condiciones.taxativas.CondicionMayorTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionPorMediana;
import model.formas.de.aplicacion.AplicacionPorPromedio;
import model.formas.de.aplicacion.AplicacionPorSumatoria;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;

public class CondicionMayorTaxativaTest extends CondicionTest {

	@Test
	public void condicionMayorTaxativaConAplicacionSimpleTest() {
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionSimple, null, 2, 1);
		Metodologia metodologia = new Metodologia("Cuenta 1 mayor a 2 en el ultimo periodo", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorSumatoriaTest() {
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorSumatoria, null, 7, 3);
		Metodologia metodologia = new Metodologia("Sumatoria en los ultimos 3 periodos de la Cuenta 1 mayor a 7", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorPromedioTest() {
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorPromedio, null, 2, 3);
		Metodologia metodologia = new Metodologia("Promedio de los ultimos 3 periodos de la Cuenta 1 mayor a 2", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorMedianaTest() {
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorMediana, null, 2, 3);
		Metodologia metodologia = new Metodologia("Mediana de los ultimos 3 periodos de la Cuenta 1 mayor a 2", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorConsistenciaTest() {
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorConsistencia, null, 0.5, 3);
		Metodologia metodologia = new Metodologia("Cuenta 1 mayor a 0.5 en los ultimos 3 periodos", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
