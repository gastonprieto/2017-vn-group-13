package utils;


import org.junit.After;
import org.junit.Test;
import exception.IndicadorException;
import model.RepositorioDeIndicadores;

public class InterpretadorDeIndicadoresTest {
	
	@After
	public void tearDown() {
		RepositorioDeIndicadores.getInstance().getIndicadores().clear();
	}
	
	@Test(expected = IndicadorException.class)
	public void interpretarIndicadorVacio() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		interpretador.interpretar("Indicador", "");
	}
	
/*	@Test
	public void interpretarSumaDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador", "1+3+6");
		Assert.assertTrue(10 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarRestaDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador", "3-2-1");
		Assert.assertTrue(0 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarMultiplicacionDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador", "3*5*2");
		Assert.assertTrue(30 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarDivisionDeTresConstantes() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador", "15/3/5");
		Assert.assertTrue(1 == indicador.aplicar(null, null));
	}
	
	@Test
	public void interpretarOperacionesCombinadas() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador", "10*0.4+8*2-6/2");
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
		Indicador indicador = interpretador.interpretar("Indicador", "Cuenta*2/5+8*2-6/2");
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
		Indicador indicador = interpretador.interpretar("Indicador", "Cuenta*2/5+Cuenta2*2-6/Cuenta3");
		Assert.assertTrue(17 == indicador.aplicar(empresa, periodo));
	}
	
	@Test
	public void registrarUnIndicador() {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicador = interpretador.interpretar("Indicador", "0");
		RepositorioDeIndicadores.getInstance().registrarIndicador(indicador);
		Assert.assertTrue(RepositorioDeIndicadores.getInstance().getIndicadores().contains(indicador));
	}
	
	@Test
	public void aplicarIndicadoresAnidadosConCuentas() {
		Periodo periodo = new Periodo(2017, 1);
		Collection<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(new Cuenta("Cuenta", 10D, periodo));
		cuentas.add(new Cuenta("Cuenta2", 8D, periodo));
		cuentas.add(new Cuenta("Cuenta3", 2D, periodo));
		Empresa empresa = new Empresa();
		empresa.setName("Empresa de prueba");
		empresa.setCuentas(cuentas);
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		RepositorioDeIndicadores.getInstance().registrarIndicador(interpretador.interpretar("Indicador", "Cuenta*2/5+Cuenta2*2"));
		Indicador otroIndicador = interpretador.interpretar("Otro Indicador", "Indicador-6/Cuenta3");
		Assert.assertTrue(17 == otroIndicador.aplicar(empresa, periodo));
	}*/
}