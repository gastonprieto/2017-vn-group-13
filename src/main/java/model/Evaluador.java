package model;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by rapap on 10/09/2017.
 */
public class Evaluador {

    private Metodologia metodologiaSeleccionada;
    private Stream<Empresa> empresasSeleccionadas;
    private Stream<Empresa> resultado; // este puede ser q este de mas


    public Evaluador(Metodologia _metodologia, Stream<Empresa> _empresasSeleccionadas){
        this.metodologiaSeleccionada = _metodologia;
        this.empresasSeleccionadas = _empresasSeleccionadas;
        this.resultado = new ArrayList<Empresa>().stream();
    }

    public Stream<Empresa> procesar(){
        this.procesarCondicionesTaxativas();
        this.procesarCondicionesPrioridad();
        return this.empresasSeleccionadas;
    }

    private void procesarCondicionesTaxativas(){
        this.metodologiaSeleccionada.getCondicionesTaxativas().stream().forEach(condicion ->  this.empresasSeleccionadas.filter(empresa -> condicion.aplicar(empresa)));
    }

    private void procesarCondicionesPrioridad(){

    }

}
