package model;
import java.util.ArrayList;

/**
 * Created by rapap on 06/08/2017.
 */
public class CondicionesTest {
  /*  ImportadorDeDatos importador;

    InterpretadorDeIndicadores interprete ;

    FabricaCondicionesDePrioridad fabrica;

    Stream<String> streamEmpresasResultadoCreciente;
    Stream<String> streamEmpresasResultadoDecreciente;

    Indicador indicadorPrueba;

    private CondicionPrioridad condicionCreciente;
    private CondicionPrioridad condicionDecreciente;

    @Before
    public void setUp() {

        //Lleno el repositrio de Empresas
        importador = new ImportadorDeDatos();
        importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");

        /* Retiramos del repositorio las Empresas 6 por no tener la Cuenta1 y la Empresa 7 por no tener la
        * Cuenta 1 en el periodo -> año 2016, semestre 2*/
     /*   Empresa empresa = new Empresa();
        empresa.setName("Empresa 6");
        empresa.setCuentas(new ArrayList<>());
        RepositorioDeEmpresas.getInstance().getEmpresas().remove(empresa);
        empresa.setName("Empresa 7");
        ArrayList<Cuenta> cuentas =new ArrayList<>();
        cuentas.add(new Cuenta("Cuenta 1", 5.0, new Periodo(0 ,0)));
        empresa.setCuentas(cuentas);
        RepositorioDeEmpresas.getInstance().getEmpresas().remove(empresa);

        /*Creo las listas ordenadas segun el resultado esperado para comparar en el test*/

        ArrayList<String> EmpresasResultadoCreciente = new ArrayList<String>();
        ArrayList<String> EmpresasResultadoDecreciente = new ArrayList<String>();

        //Decreciente
    /*    EmpresasResultadoDecreciente.add("Empresa 5");
        EmpresasResultadoDecreciente.add("Empresa 4");
        EmpresasResultadoDecreciente.add("Empresa 3");
        EmpresasResultadoDecreciente.add("Empresa 2");
        EmpresasResultadoDecreciente.add("Empresa 1");

        streamEmpresasResultadoDecreciente = EmpresasResultadoDecreciente.stream();

        //Creciente
        EmpresasResultadoCreciente.add("Empresa 1");
        EmpresasResultadoCreciente.add("Empresa 2");
        EmpresasResultadoCreciente.add("Empresa 3");
        EmpresasResultadoCreciente.add("Empresa 4");
        EmpresasResultadoCreciente.add("Empresa 5");

        streamEmpresasResultadoCreciente = EmpresasResultadoCreciente.stream();

        /*Creo un indicador para probar la condiciones y la guardo en el Repositorio de Indicadores*/
  /*      interprete = new InterpretadorDeIndicadores();
        indicadorPrueba = interprete.interpretar("Indicador1",    "Cuenta 1+2000");
        RepositorioDeIndicadores.getInstance().registrarIndicador(indicadorPrueba);

        /*Creo las Condiciones */
/*        fabrica = new FabricaCondicionesDePrioridad("CondicionCreciente", indicadorPrueba  , 1, "Creciente");
        condicionCreciente = fabrica.CrearCondicion();

        fabrica = new FabricaCondicionesDePrioridad("CondicionDecreciente", indicadorPrueba , 1, "Decreciente");
        condicionDecreciente = fabrica.CrearCondicion();
    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
        RepositorioDeIndicadores.getInstance().getIndicadores().clear();
        Resultado.getInstance().setResultadoEmpresas(null); // No se si esta bien, tal e habria que ir a la clase y crear un metodo clear...
    }


    @Test
    public void AplicarCrecienteTest()  throws ParserException {
        Stream<Empresa> Resultado =  condicionCreciente.aplicar();
        Stream<String> ResultadoString =Simplificar(Resultado);
        Assert.assertArrayEquals( ResultadoString.toArray(), streamEmpresasResultadoCreciente.toArray());
    }

    private Stream<String> Simplificar( Stream<Empresa> streamSimplifacar){
        ArrayList<String> simplificacion = new ArrayList<>();
        streamSimplifacar.forEach( e -> simplificacion.add(e.getName()));
        return simplificacion.stream();
    }





*/









}


