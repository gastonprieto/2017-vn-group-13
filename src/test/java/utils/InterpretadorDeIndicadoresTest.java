package utils;

import org.junit.Assert;
import org.junit.Test;

import model.Indicador;

public class InterpretadorDeIndicadoresTest {
	
	@Test
	public void interpretarSumaDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicadorInterpretado = new Indicador("", interpretador.interpretar("1+3+6"));
		Assert.assertTrue(10 == indicadorInterpretado.aplicar());
	}
	
	@Test
	public void interpretarRestaDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicadorInterpretado = new Indicador("", interpretador.interpretar("3-2-1"));
		Assert.assertTrue(0 == indicadorInterpretado.aplicar());
	}
	
	@Test
	public void interpretarMultiplicacionDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicadorInterpretado = new Indicador("", interpretador.interpretar("3*5*2"));
		Assert.assertTrue(30 == indicadorInterpretado.aplicar());
	}
	
	@Test
	public void interpretarDivisionDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicadorInterpretado = new Indicador("", interpretador.interpretar("15/3/5"));
		Assert.assertTrue(1 == indicadorInterpretado.aplicar());
	}
	
	@Test
	public void interpretarOperacionesCombinadas() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicadorInterpretado = new Indicador("", interpretador.interpretar("10*2/5+8*2-6/2"));
		Assert.assertTrue(17 == indicadorInterpretado.aplicar());
	}
}
