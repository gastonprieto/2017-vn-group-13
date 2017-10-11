package model.metodologias;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Cuenta;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.Periodo;
import model.condiciones.prioritarias.CondicionMayorPrioritaria;
import model.condiciones.prioritarias.CondicionMenorPrioritaria;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionCrecienteTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.FormaAplicacionEnum;
import utils.File.InterpretadorDeIndicadores;

public class MetodologiaWarrenBuffetTest {

	Metodologia metodologiaWarrenBuffet;
	List<Empresa> empresas;
	
	@Before
	public void setUp() {
		empresas = new ArrayList<>();
		
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		
		Indicador nivelDeDeuda = interpretadorDeIndicadores.interpretar("Nivel de deuda", "Cuenta 3");
		CondicionPrioritaria minimizarNivelDeDeuda =
				new CondicionMenorPrioritaria(nivelDeDeuda, FormaAplicacionEnum.AplicacionSimple, null, 1);
		
		Indicador roe = interpretadorDeIndicadores.interpretar("ROE", "Cuenta 2");
		CondicionPrioritaria maximizarROE = 
				new CondicionMayorPrioritaria(roe, FormaAplicacionEnum.AplicacionPorConsistencia, minimizarNivelDeDeuda, 5);
		
		Indicador margenes = interpretadorDeIndicadores.interpretar("Margenes", "Cuenta 1");
		CondicionTaxativa margenesConsistentementeCrecientes = new CondicionCrecienteTaxativa(margenes, null, 5);
		
		metodologiaWarrenBuffet = new Metodologia("Warren Buffet", maximizarROE, margenesConsistentementeCrecientes);
		
		Periodo primerSemestre2015 = new Periodo(2015, 1);
		Periodo segundoSemestre2015 = new Periodo(2015, 2);
		Periodo primerSemestre2016 = new Periodo(2016, 1);
		Periodo segundoSemestre2016 = new Periodo(2016, 2);
		Periodo primerSemestre2017 = new Periodo(2017, 1);
		
		List<Cuenta> cuentasEmpresa1 = new ArrayList<>();
		
		cuentasEmpresa1.add(new Cuenta("Cuenta 1", 100d, primerSemestre2015));
		cuentasEmpresa1.add(new Cuenta("Cuenta 1", 100d, segundoSemestre2015));
		cuentasEmpresa1.add(new Cuenta("Cuenta 1", 100d, primerSemestre2016));
		cuentasEmpresa1.add(new Cuenta("Cuenta 1", 100d, segundoSemestre2016));
		cuentasEmpresa1.add(new Cuenta("Cuenta 1", 100d, primerSemestre2017));
		
		cuentasEmpresa1.add(new Cuenta("Cuenta 2", 100d, primerSemestre2015));
		cuentasEmpresa1.add(new Cuenta("Cuenta 2", 100d, segundoSemestre2015));
		cuentasEmpresa1.add(new Cuenta("Cuenta 2", 100d, primerSemestre2016));
		cuentasEmpresa1.add(new Cuenta("Cuenta 2", 100d, segundoSemestre2016));
		cuentasEmpresa1.add(new Cuenta("Cuenta 2", 100d, primerSemestre2017));
		
		cuentasEmpresa1.add(new Cuenta("Cuenta 3", 100d, primerSemestre2017));
		
		List<Cuenta> cuentasEmpresa2 = new ArrayList<>();
		
		cuentasEmpresa2.add(new Cuenta("Cuenta 1", 100d, primerSemestre2015));
		cuentasEmpresa2.add(new Cuenta("Cuenta 1", 101d, segundoSemestre2015));
		cuentasEmpresa2.add(new Cuenta("Cuenta 1", 102d, primerSemestre2016));
		cuentasEmpresa2.add(new Cuenta("Cuenta 1", 103d, segundoSemestre2016));
		cuentasEmpresa2.add(new Cuenta("Cuenta 1", 104d, primerSemestre2017));
		
		cuentasEmpresa2.add(new Cuenta("Cuenta 2", 100d, primerSemestre2015));
		cuentasEmpresa2.add(new Cuenta("Cuenta 2", 100d, segundoSemestre2015));
		cuentasEmpresa2.add(new Cuenta("Cuenta 2", 100d, primerSemestre2016));
		cuentasEmpresa2.add(new Cuenta("Cuenta 2", 100d, segundoSemestre2016));
		cuentasEmpresa2.add(new Cuenta("Cuenta 2", 100d, primerSemestre2017));
		
		cuentasEmpresa2.add(new Cuenta("Cuenta 3", 100d, primerSemestre2017));
		
		List<Cuenta> cuentasEmpresa3 = new ArrayList<>();
		
		cuentasEmpresa3.add(new Cuenta("Cuenta 1", 100d, primerSemestre2015));
		cuentasEmpresa3.add(new Cuenta("Cuenta 1", 101d, segundoSemestre2015));
		cuentasEmpresa3.add(new Cuenta("Cuenta 1", 102d, primerSemestre2016));
		cuentasEmpresa3.add(new Cuenta("Cuenta 1", 103d, segundoSemestre2016));
		cuentasEmpresa3.add(new Cuenta("Cuenta 1", 104d, primerSemestre2017));
		
		cuentasEmpresa3.add(new Cuenta("Cuenta 2", 105d, primerSemestre2015));
		cuentasEmpresa3.add(new Cuenta("Cuenta 2", 105d, segundoSemestre2015));
		cuentasEmpresa3.add(new Cuenta("Cuenta 2", 105d, primerSemestre2016));
		cuentasEmpresa3.add(new Cuenta("Cuenta 2", 105d, segundoSemestre2016));
		cuentasEmpresa3.add(new Cuenta("Cuenta 2", 105d, primerSemestre2017));
		
		cuentasEmpresa3.add(new Cuenta("Cuenta 3", 100d, primerSemestre2017));
		
		List<Cuenta> cuentasEmpresa4 = new ArrayList<>();
		
		cuentasEmpresa4.add(new Cuenta("Cuenta 1", 100d, primerSemestre2015));
		cuentasEmpresa4.add(new Cuenta("Cuenta 1", 101d, segundoSemestre2015));
		cuentasEmpresa4.add(new Cuenta("Cuenta 1", 102d, primerSemestre2016));
		cuentasEmpresa4.add(new Cuenta("Cuenta 1", 103d, segundoSemestre2016));
		cuentasEmpresa4.add(new Cuenta("Cuenta 1", 104d, primerSemestre2017));
		
		cuentasEmpresa4.add(new Cuenta("Cuenta 2", 100d, primerSemestre2015));
		cuentasEmpresa4.add(new Cuenta("Cuenta 2", 100d, segundoSemestre2015));
		cuentasEmpresa4.add(new Cuenta("Cuenta 2", 100d, primerSemestre2016));
		cuentasEmpresa4.add(new Cuenta("Cuenta 2", 100d, segundoSemestre2016));
		cuentasEmpresa4.add(new Cuenta("Cuenta 2", 100d, primerSemestre2017));
		
		cuentasEmpresa4.add(new Cuenta("Cuenta 3", 99d, primerSemestre2017));
		
		Empresa empresa1 = new Empresa();
		empresa1.setName("Empresa 1");
		empresa1.setCuentas(cuentasEmpresa1);
		empresas.add(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setName("Empresa 2");
		empresa2.setCuentas(cuentasEmpresa2);
		empresas.add(empresa2);
		
		Empresa empresa3 = new Empresa();
		empresa3.setName("Empresa 3");
		empresa3.setCuentas(cuentasEmpresa3);
		empresas.add(empresa3);
		
		Empresa empresa4 = new Empresa();
		empresa4.setName("Empresa 4");
		empresa4.setCuentas(cuentasEmpresa4);
		empresas.add(empresa4);
	}
	
	@Test
	public void metodologiaWarrenBuffetDescartaUnaEmpresaTest() {
		assertEquals(3, metodologiaWarrenBuffet.evaluar(empresas).size());
	}
	
	@Test
	public void mejorEmpresaSegunLaMetodologiaWarrenBuffetTest() {
		assertEquals("Empresa 3", metodologiaWarrenBuffet.evaluar(empresas).iterator().next().getName());
	}
	
	@Test
	public void segundaEmpresaSegunLaMetodologiaWarrenBuffetTest() {
		Iterator<Empresa> iterator = metodologiaWarrenBuffet.evaluar(empresas).iterator();
		iterator.next();
		assertEquals("Empresa 4", iterator.next().getName());
	}
	
	@Test
	public void ultimaEmpresaSegunLaMetodologiaWarrenBuffetTest() {
		Iterator<Empresa> iterator = metodologiaWarrenBuffet.evaluar(empresas).iterator();
		iterator.next();
		iterator.next();
		assertEquals("Empresa 2", iterator.next().getName());
	}
}
