package model.Condicion.Prioridad;

import model.Empresa;
import model.Indicador;
import model.Periodo;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public class CondicionMaximizar extends CondicionPrioridad {
  
	public CondicionMaximizar(String name, Indicador indicador, int cantidadDePeriodos){

    }

    @Override
    public int comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos) {
        return 0;
    }
}
