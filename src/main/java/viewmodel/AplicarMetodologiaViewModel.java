package viewmodel;

import Repositorio.RepositorioDeEmpresas;
import Repositorio.RepositorioDeMetodologias;
import model.*;
import org.uqbar.commons.utils.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by rapap on 27/07/2017.
 */

@Observable
public class AplicarMetodologiaViewModel {
	


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
     //   Collection<Empresa> TodasLasEmpresas = RepositorioDeEmpresas.getInstance().getEmpresas();
       // Evaluador Evaluacion = new Evaluador(metodologiaSeleccionada, TodasLasEmpresas.stream());
       // resultadoEmpresasEvaluadas = Evaluacion.procesar().collect(Collectors.toList());
    }
}
