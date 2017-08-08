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

        indicadorCreciente = interprete.interpretar("Indicador1",    "Cuenta1-1");
        indicadorDecreciente = interprete.interpretar("indicador2", "Cuenta1+1");

        fabrica = new FabricaCondicionesDePrioridad("CondicionCreciente", indicadorCreciente  , 2, "Creciente");
        condicionCreciente = fabrica.ObtenerCondicion();

        fabrica = new FabricaCondicionesDePrioridad("CondicionCreciente", indicadorDecreciente , 1, "Decreciente");
        condicionDecreciente = fabrica.ObtenerCondicion();

        streamEmpresasResultadoCreciente = RepositorioDeEmpresas.getInstance().getEmpresas().stream();

    }

    @After
    public void tearDown() {
        RepositorioDeEmpresas.getInstance().getEmpresas().clear();
    }

    @Test
    public void AplicarCrecienteTest()  throws ParserException {
        Stream<Empresa> Resultado =  condicionCreciente.aplicar(RepositorioDeEmpresas.getInstance().getEmpresas().stream());
        Assert.assertTrue(Resultado.equals(streamEmpresasResultadoCreciente));
    }















}


