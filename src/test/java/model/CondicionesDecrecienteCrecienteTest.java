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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Created by rapap on 06/08/2017.
 */
public class CondicionesDecrecienteCrecienteTest {
    ImportadorDeDatos importador;

    InterpretadorDeIndicadores interprete ;

    FabricaCondicion fabrica;

    Stream<String> streamEmpresasResultadoCreciente;
    Stream<String> streamEmpresasResultadoDecreciente;

    Indicador indicadorPrueba;

    private Condicion condicionCreciente;
    private Condicion condicionDecreciente;

    @Before
    public void setUp() {

        //Lleno el repositrio de Empresas
        importador = new ImportadorDeDatos();
        importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");

        /* Retiramos del repositorio las Empresas 6 por no tener la Cuenta1 y la Empresa 7 por no tener la
        * Cuenta 1 en el periodo -> año 2016, semestre 2*/
        Empresa empresa = new Empresa();
        empresa.setName("Empresa 6");
        empresa.setCuentas(new ArrayList<>());
        RepositorioDeEmpresas.getInstance().getEmpresas().remove(empresa);
        empresa.setName("Empresa 7");
        ArrayList<Cuenta> cuentas =new ArrayList<>();
        cuentas.add(new Cuenta("Cuenta 1", 5.0, new Periodo(0 ,0)));
        empresa.setCuentas(cuentas);
        RepositorioDeEmpresas.getInstance().getEmpresas().remove(empresa);

        /*Creo las listas ordenadas segun el resultado esperado para comparar en el test*/

        ArrayList<String> EmpresasResultado = new ArrayList<String>();

        //Decreciente
        EmpresasResultado.add("Empresa 1");
        EmpresasResultado.add("Empresa 2");
        EmpresasResultado.add("Empresa 3");
        EmpresasResultado.add("Empresa 4");
        EmpresasResultado.add("Empresa 5");

        streamEmpresasResultadoDecreciente = EmpresasResultado.stream();

        EmpresasResultado.clear();
        //Creciente
        EmpresasResultado.add("Empresa 5");
        EmpresasResultado.add("Empresa 4");
        EmpresasResultado.add("Empresa 3");
        EmpresasResultado.add("Empresa 2");
        EmpresasResultado.add("Empresa 1");


        streamEmpresasResultadoCreciente = EmpresasResultado.stream();

        /*Creo un indicador para probar la condiciones y la guardo en el Repositorio de Indicadores*/
        interprete = new InterpretadorDeIndicadores();
        indicadorPrueba = interprete.interpretar("Indicador1",    "Cuenta 1+2000");
        RepositorioDeIndicadores.getInstance().registrarIndicador(indicadorPrueba);

        /*Creo las Condiciones */
        fabrica = new FabricaCondicionesDePrioridad("CondicionCreciente", indicadorPrueba  , 1, "Creciente");
        condicionCreciente = fabrica.ObtenerCondicion();

        fabrica = new FabricaCondicionesDePrioridad("CondicionDecreciente", indicadorPrueba , 1, "Decreciente");
        condicionDecreciente = fabrica.ObtenerCondicion();
    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
        RepositorioDeIndicadores.getInstance().getIndicadores().clear();
    }

    @Test
    public void AplicarDecrecienteTest()  throws ParserException {
        Collection<Empresa> ListaDeEmpresas = RepositorioDeEmpresas.getInstance().getEmpresas();
        Stream<Empresa> streamEmpresas = ListaDeEmpresas.stream();

        Stream<Empresa> Resultado =  condicionDecreciente.aplicar(streamEmpresas);
        Stream<String> ResultadoString =Simplificar(Resultado);
        Assert.assertArrayEquals( ResultadoString.toArray(), streamEmpresasResultadoDecreciente.toArray());

    }

    @Test
    public void AplicarCrecienteTest()  throws ParserException {
        Collection<Empresa> ListaDeEmpresas = RepositorioDeEmpresas.getInstance().getEmpresas();
        Stream<Empresa> streamEmpresas = ListaDeEmpresas.stream();

        Stream<Empresa> Resultado =  condicionCreciente.aplicar(streamEmpresas);
        Stream<String> ResultadoString =Simplificar(Resultado);
        Assert.assertArrayEquals( ResultadoString.toArray(), streamEmpresasResultadoCreciente.toArray());
    }

    private Stream<String> Simplificar( Stream<Empresa> streamSimplifacar){
        ArrayList<String> simplificacion = new ArrayList<>();
        streamSimplifacar.forEach( e -> simplificacion.add(e.getName()));
        return simplificacion.stream();
    }















}


