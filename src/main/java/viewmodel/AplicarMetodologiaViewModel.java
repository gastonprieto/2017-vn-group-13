package viewmodel;

import model.Condicion;
import model.CondicionMayor;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.RepositorioDeEmpresas;
import model.RepositorioDeMetodologias;
import model.Sumatoria;
import utils.InterpretadorDeIndicadores;

import org.uqbar.commons.utils.Observable;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by rapap on 27/07/2017.
 */

@Observable
public class AplicarMetodologiaViewModel {
	
	public AplicarMetodologiaViewModel() {
		InterpretadorDeIndicadores interprete = new InterpretadorDeIndicadores();		
		Indicador indicadorMayor = interprete.interpretar("ROE","2+Cuenta 1");
		
		Condicion condicion1 = new CondicionMayor("CondicionMayor1", 20, 10, new Sumatoria(indicadorMayor));
		Collection<Condicion> condiciones = new ArrayList();
		condiciones.add(condicion1);
		
		Metodologia metodologia = new Metodologia("WB", condiciones);
		RepositorioDeMetodologias.getInstance().registrarMetodologia(metodologia);
	}

    private Metodologia metodologiaSeleccionada;
    private Collection<Empresa> resultadoEmpresasEvaluadas = new ArrayList<>();

    /*-- metodologiaSeleccionada--*/
    public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
        this.metodologiaSeleccionada = metodologiaSeleccionada;
    }
    public Metodologia getMetodologiaSeleccionada() {
        return metodologiaSeleccionada;
    }
    public Collection<Metodologia> getMetodologias(){return RepositorioDeMetodologias.getInstance().getMetodologias();}

    /*-- resultadoEmpresasEvaluadas--*/
    public Collection<Empresa> getResultadoEmpresasEvaluadas() {
        return resultadoEmpresasEvaluadas;
    }
    public void setResultadoEmpresasEvaluadas(Collection<Empresa> resultadoEmpresasEvaluadas) {
        this.resultadoEmpresasEvaluadas = resultadoEmpresasEvaluadas;
    }

    /* -- FUNCIONES --*/

    public void aplicarMetodologiaSeleccionada(){
        Collection<Empresa> TodasLasEmpresas = RepositorioDeEmpresas.getInstance().getEmpresas();
        resultadoEmpresasEvaluadas = metodologiaSeleccionada.evaluar(TodasLasEmpresas);
    }
}
