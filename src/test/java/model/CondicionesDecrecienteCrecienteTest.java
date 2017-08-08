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


    Stream<Empresa> streamEmpresas;
    Stream<Empresa> streamEmpresasResultadoCreciente;
    Stream<Empresa> streamEmpresasMenor;

    Indicador indicadorCreciente;
    Indicador indicadorDecreciente;

    private Condicion condicionCreciente;
    private Condicion condicionDecreciente;

    @Before
    public void setUp() {

        //Lleno el repositrio de Empresas
        importador = new ImportadorDeDatos();
        importador.importarRepositorioDeEmpresas(System.getProperty("user.dir") + "/src/test/assets/Cuentas.txt");

        interprete = new InterpretadorDeIndicadores();

        indicadorCreciente = interprete.interpretar("Indicador1",    "Cuenta 1+2000");
        indicadorDecreciente = interprete.interpretar("indicador2", "Cuenta 1+1");

        RepositorioDeIndicadores.getInstance().registrarIndicador(indicadorCreciente);
        RepositorioDeIndicadores.getInstance().registrarIndicador(indicadorDecreciente);

        fabrica = new FabricaCondicionesDePrioridad("CondicionCreciente", indicadorCreciente  , 1, "Creciente");
        condicionCreciente = fabrica.ObtenerCondicion();

        fabrica = new FabricaCondicionesDePrioridad("CondicionCreciente", indicadorDecreciente , 1, "Decreciente");
        condicionDecreciente = fabrica.ObtenerCondicion();

        Empresa empresa = new Empresa();
        empresa.setName("Empresa 6");
        empresa.setCuentas(new ArrayList<>());
        RepositorioDeEmpresas.getInstance().getEmpresas().remove(empresa);
        Collection<Empresa> lista = RepositorioDeEmpresas.getInstance().getEmpresas();
        Collection<Empresa> ListaDeEmpresas = RepositorioDeEmpresas.getInstance().getEmpresas();
        streamEmpresasResultadoCreciente = ListaDeEmpresas.stream();

    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
        RepositorioDeIndicadores.getInstance().getIndicadores().clear();
    }

    @Test
    public void AplicarCrecienteTest()  throws ParserException {
        Collection<Empresa> ListaDeEmpresas = RepositorioDeEmpresas.getInstance().getEmpresas();
        Stream<Empresa> Resultado =  condicionDecreciente.aplicar(ListaDeEmpresas.stream());
        Assert.assertTrue(Resultado.toArray().equals(streamEmpresasResultadoCreciente.toArray()));
    }















}


