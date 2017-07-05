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
import org.junit.Before;
import org.junit.Test;

import exception.ParserException;
import model.Cuenta;
import model.Empresa;
import model.Periodo;
import model.RepositorioDeEmpresas;
import utils.ImportadorDeDatos;

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

        indicador1 = new Indicador("Prueba 1");
        //indicador1.setOperacion();

        condicion1 = new Condicion(indicador1, indicador1);
    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
    }

    @Test
    public void EsMayorQueUnValorTest  () throws ParserException {

                }
}