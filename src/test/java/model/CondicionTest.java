package model;

/**
 * Created by rapap on 01/07/2017.
 */

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exception.ParserException;
//import scala.collection.immutable.Stream;
import utils.ImportadorDeDatos;
import utils.InterpretadorDeIndicadores;

public class CondicionTest {
    ImportadorDeDatos importador;

    Empresa retornoEsperadoEmpresa;

    ArrayList<Cuenta> listaCuentasEmpresa;

    Indicador indicador1;

    private Cuenta cuentaCreciente1;
    private Cuenta cuentaCreciente2;
    private Cuenta cuentaCreciente3;

    private Periodo periodo1;
    private Periodo periodo2;
    private Periodo periodo3;

    private Condicion condicion1;

    @Before
    public void setUp() {

        importador = new ImportadorDeDatos();
        importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");

        retornoEsperadoEmpresa = new Empresa();

        listaCuentasEmpresa = new ArrayList<Cuenta>();

        cuentaCreciente1 = new Cuenta();
        cuentaCreciente1.setName("Cuenta 1");
        cuentaCreciente1.setValue((double) 1);

        periodo1 = new Periodo();
        periodo1.setSemester(1);
        periodo1.setYear(2016);
        cuentaCreciente1.setPeriodo(periodo1);

        cuentaCreciente2 = new Cuenta();
        cuentaCreciente2.setName("Cuenta 1");
        cuentaCreciente2.setValue((double) 3);

        periodo2 = new Periodo();
        periodo2.setSemester(2);
        periodo2.setYear(2016);
        cuentaCreciente2.setPeriodo(periodo2);

        cuentaCreciente3 = new Cuenta();
        cuentaCreciente3.setName("Cuenta 1");
        cuentaCreciente3.setValue((double) 5);

        periodo3 = new Periodo();
        periodo3.setSemester(1);
        periodo3.setYear(2017);
        cuentaCreciente3.setPeriodo(periodo3);

        indicador1 = new Indicador("pruebaAscendente");
        
        
    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
    }

    @Test
    public void EsMayorQueUnValorTest  () throws ParserException {

                }
    
    @Test
    public void ListaAscendiente  () throws ParserException {

    	
    	InterpretadorDeIndicadores interprete = new InterpretadorDeIndicadores();
    	
    	Empresa empresa1 = new Empresa();
    	empresa1.setName("YPF");
    	Empresa empresa2 = new Empresa();
    	empresa2.setName("Exxon");
    	Empresa empresa3 = new Empresa();
    	empresa3.setName("Oracle");
    	
    	indicador1 = interprete.interpretar("indicadorAscendente","2*Cuenta 1");
    	
        periodo1 = new Periodo();
        periodo1.setSemester(1);
        periodo1.setYear(2016);

        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        periodos.add(periodo1);
        
        cuentaCreciente1 = new Cuenta();
        cuentaCreciente1.setName("Cuenta 1");
        cuentaCreciente1.setValue((double) 1);
        cuentaCreciente1.setPeriodo(periodo1);
  
        cuentaCreciente2 = new Cuenta();
        cuentaCreciente2.setName("Cuenta 1");
        cuentaCreciente2.setValue((double) 3);
        cuentaCreciente2.setPeriodo(periodo1);

        cuentaCreciente3 = new Cuenta();
        cuentaCreciente3.setName("Cuenta 1");
        cuentaCreciente3.setValue((double) 5);
        cuentaCreciente3.setPeriodo(periodo1);
        
        ArrayList<Cuenta> cuentasEmpresa1 = new ArrayList<>();
        ArrayList<Cuenta> cuentasEmpresa2 = new ArrayList<>();
        ArrayList<Cuenta> cuentasEmpresa3 = new ArrayList<>();
        
        cuentasEmpresa1.add(cuentaCreciente1);
        cuentasEmpresa2.add(cuentaCreciente2);
        cuentasEmpresa3.add(cuentaCreciente3);
        
        empresa1.setCuentas(cuentasEmpresa1);
        empresa2.setCuentas(cuentasEmpresa2);
        empresa3.setCuentas(cuentasEmpresa3);
        
        ArrayList<Empresa> empresas = new ArrayList<Empresa>();
        empresas.add(empresa1);
        empresas.add(empresa2);
        empresas.add(empresa3);

        java.util.stream.Stream<Empresa> streamEmpresas =  empresas.stream();
        Empresa primera = new Empresa();
        CondicionCreciente condicion1 = new CondicionCreciente("hola", indicador1, periodos);
        primera =  condicion1.aplicar(streamEmpresas).findFirst().get();
        
        Assert.assertTrue(primera.getName().equals("Oracle"));
        
        }
    
}
