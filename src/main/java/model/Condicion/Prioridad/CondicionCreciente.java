package model.Condicion.Prioridad;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import org.uqbar.commons.utils.Observable;

import java.util.Collection;

@Observable
public class CondicionCreciente extends CondicionPrioridad {


    public CondicionCreciente(){}

    public CondicionCreciente(String name, Indicador indicador, int cantidadDePeriodos){
        this.name = name;
        this.indicador = indicador;
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

    @Override
    public int comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos) {
        return  Double.compare(indicador.aplicar(empresa1, periodos), indicador.aplicar(empresa2, periodos));
    }
}
