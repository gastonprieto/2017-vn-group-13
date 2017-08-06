package model;
import exception.ParserException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ImportadorDeDatos;
import utils.InterpretadorDeIndicadores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Created by rapap on 06/08/2017.
 */
public class CondicionesDecrecienteCrecienteTest {
    ImportadorDeDatos importador;

    Empresa retornoEsperadoEmpresa;

    InterpretadorDeIndicadores interprete ;

    FabricaCondicion fabrica;
    private Periodo periodoUnico;
    private Collection<Periodo> periodos;

    private Cuenta cuentaMayor;
    private Cuenta cuentaMenor;

    private ArrayList<Cuenta> listCuentasMayor;
    private ArrayList<Cuenta> listCuentasMenor;

    private Empresa empresaMayor;
    private Empresa empresaMenor;

    private ArrayList<Empresa> listaEmpresas;
    private ArrayList<Empresa> listaEmpresasMeyor;
    private ArrayList<Empresa> listaEmpresasMenor;

    Stream<Empresa> streamEmpresas;
    Stream<Empresa> streamEmpresasMayor;
    Stream<Empresa> streamEmpresasMenor;

    Indicador indicadorMayor;
    Indicador indicadorMenor;

    private Condicion condicionMayor;
    private Condicion condicionMenor;

    @Before
    public void setUp() {


        //fabrica = new FabricaCondicionesDePrioridad("", , 10, "");


	    //fabrica = new FabricaCondicionTaxativas(nombreCondicion, tipoIndicadorSeleccionada, indicadorSeleccionado, 10, tipoCondicionSeleccionada, 10.1);


        /*
        importador = new ImportadorDeDatos();
        importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");

        periodoUnico = new Periodo();
        periodoUnico.setSemester(1);
        periodoUnico.setYear(2016);

        cuentaMayor = new Cuenta();
        cuentaMayor.setName("CuentaMayor");
        cuentaMayor.setValue(20.1);
        cuentaMayor.setPeriodo(periodoUnico);

        cuentaMenor = new Cuenta();
        cuentaMenor.setName("CuentaMenor");
        cuentaMenor.setValue(1.1);
        cuentaMenor.setPeriodo(periodoUnico);

        listCuentasMayor = new ArrayList<Cuenta>();
        listCuentasMayor.add(cuentaMayor);

        listCuentasMenor = new ArrayList<Cuenta>();
        listCuentasMenor.add(cuentaMenor);

        empresaMayor = new Empresa();
        empresaMayor.setName("EmpresaMayor");
        empresaMayor.setCuentas(listCuentasMayor);

        empresaMenor = new Empresa();
        empresaMenor.setName("EmpresaMenor");
        empresaMenor.setCuentas(listCuentasMenor);

        listaEmpresas = new ArrayList<Empresa>();
        listaEmpresas.add(empresaMayor);
        listaEmpresas.add(empresaMenor);

        listaEmpresasMeyor = new ArrayList<Empresa>();
        listaEmpresasMeyor.add(empresaMayor);

        listaEmpresasMenor = new ArrayList<Empresa>();
        listaEmpresasMenor.add(empresaMenor);

        periodos = new ArrayList<Periodo>();
        periodos.add(periodoUnico);

        streamEmpresas = listaEmpresas.stream();
        streamEmpresasMayor = listaEmpresasMenor.stream();
        streamEmpresasMenor = listaEmpresasMenor.stream();

        interprete = new InterpretadorDeIndicadores();

        indicadorMayor = interprete.interpretar("IndicadorMayor","CuentaMayor+1");
        indicadorMenor = interprete.interpretar("indicadorMenor", "CuentaMenor+1");

        condicionMayor = new CondicionMayor("UnaCondicionMayor",8.8, indicadorMayor, periodos);
        condicionMenor = new CondicionMenor("hla",8.8, indicadorMenor, periodos);*/

    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
    }

    @Test
    public void AplicarMayorTest()  throws ParserException {
        Stream<Empresa> Resultado =  condicionMayor.aplicar(streamEmpresas);
        Assert.assertEquals(Resultado.collect(Collectors.toList()), streamEmpresasMayor.collect(Collectors.toList()));
    }


}


