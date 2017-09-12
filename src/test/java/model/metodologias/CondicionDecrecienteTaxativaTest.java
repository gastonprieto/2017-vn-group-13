package model.metodologias;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Indicador;
import model.Metodologia;
import model.condiciones.taxativas.CondicionDecrecienteTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.File.InterpretadorDeIndicadores;

public class CondicionDecrecienteTaxativaTest extends CondicionTest {

	@Test
	public void condicionMenorTaxativaConAplicacionPorConsistenciaTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		CondicionTaxativa condicionDecrecienteTaxativa = new CondicionDecrecienteTaxativa(indicador, null, 3);
		Metodologia metodologia = new Metodologia("Cuenta 1 decreciente en los ultimos 3 periodos", null, condicionDecrecienteTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
