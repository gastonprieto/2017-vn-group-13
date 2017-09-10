package model;


import Repositorio.RepositorioDeMetodologias;
import org.uqbar.commons.utils.Observable;

import java.util.stream.Stream;

/**
 * Created by rapap on 07/09/2017.
 */
@Observable
public class Resultado {

    private static Resultado instance = null;
    private Stream<Empresa> resultadoEmpresas;

    private Resultado() {

    }

    public static Resultado getInstance() {
        if(instance == null) {
            instance = new Resultado();
        }
        return instance;
    }

    public void obtenerResutado(String metodologia){
        Metodologia metodologia1Aplicar = RepositorioDeMetodologias.getInstance().BuscarMetodologia(metodologia);
       // metodologia1Aplicar.condiciones.forEach(condicion -> condicion.aplicar());
    }

    public Stream<Empresa> getResultadoEmpresas() {
        return resultadoEmpresas;
    }

    public void setResultadoEmpresas(Stream<Empresa> empresas) {
        this.resultadoEmpresas = empresas;
    }
}
