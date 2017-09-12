package model.metodologias;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Indicador;
import model.Metodologia;
import model.condiciones.taxativas.CondicionMayorTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionPorMediana;
import model.formas.de.aplicacion.AplicacionPorPromedio;
import model.formas.de.aplicacion.AplicacionPorSumatoria;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;
import utils.File.InterpretadorDeIndicadores;

public class CondicionMayorTaxativaTest extends CondicionTest {

	@Test
	public void condicionMayorTaxativaConAplicacionSimpleTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionSimple, null, 2);
		Metodologia metodologia = new Metodologia("Cuenta 1 mayor a 2 en el ultimo periodo", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorSumatoriaTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		FormaAplicacion aplicacionPorSumatoria = new AplicacionPorSumatoria(3);
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorSumatoria, null, 7);
		Metodologia metodologia = new Metodologia("Sumatoria en los ultimos 3 periodos de la Cuenta 1 mayor a 7", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorPromedioTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		FormaAplicacion aplicacionPorPromedio = new AplicacionPorPromedio(3);
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorPromedio, null, 2);
		Metodologia metodologia = new Metodologia("Promedio de los ultimos 3 periodos de la Cuenta 1 mayor a 2", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorMedianaTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		FormaAplicacion aplicacionPorMediana = new AplicacionPorMediana(3);
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorMediana, null, 2);
		Metodologia metodologia = new Metodologia("Mediana de los ultimos 3 periodos de la Cuenta 1 mayor a 2", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
	
	@Test
	public void condicionMayorTaxativaConAplicacionPorConsistenciaTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia(3);
		CondicionTaxativa condicionMayorTaxativa = new CondicionMayorTaxativa(indicador, aplicacionPorConsistencia, null, 0.5);
		Metodologia metodologia = new Metodologia("Cuenta 1 mayor a 0.5 en los ultimos 3 periodos", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
