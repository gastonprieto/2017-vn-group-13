package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.condiciones.taxativas.CondicionMayorTaxativa;
import model.condiciones.taxativas.CondicionMenorTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;
import utils.File.InterpretadorDeIndicadores;

public class MetodologiasTest {
	
	private List<Empresa> empresas;
	
	@Before
	public void setUp() {
		empresas = new ArrayList<>();
		
		Cuenta cuenta1Empresa1 = new Cuenta();
		cuenta1Empresa1.setName("Cuenta 1");
		cuenta1Empresa1.setPeriodo(new Periodo(2017, 1));
		cuenta1Empresa1.setValue(3D);
		List<Cuenta> cuentasEmpresa1 = new ArrayList<>();
		cuentasEmpresa1.add(cuenta1Empresa1);
		Empresa empresa1 = new Empresa();
		empresa1.setName("Empresa 1");
		empresa1.setCuentas(cuentasEmpresa1);
		
		Cuenta cuenta1Empresa2 = new Cuenta();
		cuenta1Empresa2.setName("Cuenta 1");
		cuenta1Empresa2.setPeriodo(new Periodo(2017, 1));
		cuenta1Empresa2.setValue(1D);
		List<Cuenta> cuentasEmpresa2 = new ArrayList<>();
		cuentasEmpresa2.add(cuenta1Empresa2);
		Empresa empresa2 = new Empresa();
		empresa2.setName("Empresa 2");
		empresa2.setCuentas(cuentasEmpresa2);
		
		empresas.add(empresa1);
		empresas.add(empresa2);
	}

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
	public void condicionMenorTaxativaConAplicacionSimpleTest() {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		Indicador indicador = interpretadorDeIndicadores.interpretar("Indicador 1", "Cuenta 1");
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionTaxativa condicionMayorTaxativa = new CondicionMenorTaxativa(indicador, aplicacionSimple, null, 2);
		Metodologia metodologia = new Metodologia("Cuenta 1 menor a 2 en el ultimo periodo", null, condicionMayorTaxativa);
		
		assertEquals(1, metodologia.evaluar(empresas).size());
	}
}
