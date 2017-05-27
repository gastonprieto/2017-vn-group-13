package utils;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Operando;
import model.Periodo;

public class InterpretadorDeIndicadoresTest {
	
	@Test
	public void interpretarSumaDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "1+3+6");
		indicador.setOperacion(operando);
		Assert.assertTrue(10 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarRestaDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "3-2-1");
		indicador.setOperacion(operando);
		Assert.assertTrue(0 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarMultiplicacionDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "3*5*2");
		indicador.setOperacion(operando);
		Assert.assertTrue(30 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarDivisionDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "15/3/5");
		indicador.setOperacion(operando);
		Assert.assertTrue(1 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarOperacionesCombinadas() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "10*2/5+8*2-6/2");
		indicador.setOperacion(operando);
		Assert.assertTrue(17 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarOperacionesConUnaVariable() {
		Periodo periodo = new Periodo(2017, 1);
		Collection<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(new Cuenta("Cuenta", 10D, periodo));
		Empresa empresa = new Empresa();
		empresa.setName("Empresa de prueba");
		empresa.setCuentas(cuentas);
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "Cuenta*2/5+8*2-6/2");
		indicador.setOperacion(operando);
		Assert.assertTrue(17 == indicador.aplicar(empresa, periodo));
	}
	
	@Test
	public void interpretarOperacionesConVariasVariables() {
		Periodo periodo = new Periodo(2017, 1);
		Collection<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(new Cuenta("Cuenta", 10D, periodo));
		cuentas.add(new Cuenta("Cuenta2", 8D, periodo));
		cuentas.add(new Cuenta("Cuenta3", 2D, periodo));
		Empresa empresa = new Empresa();
		empresa.setName("Empresa de prueba");
		empresa.setCuentas(cuentas);
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = new Indicador("");
		Operando operando = interpretador.interpretar(indicador, "Cuenta*2/5+Cuenta2*2-6/Cuenta3");
		indicador.setOperacion(operando);
		Assert.assertTrue(17 == indicador.aplicar(empresa, periodo));
	}
}
