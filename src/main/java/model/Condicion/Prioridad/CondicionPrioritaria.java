package model.Condicion.Prioridad;


import model.Empresa;
import model.Indicador;
import model.Periodo;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */


public abstract class CondicionPrioritaria  {
    protected String name;
    protected Indicador indicador;
    protected int cantidadDePeriodos;


    public abstract int comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos);

    public String getClassClean(){
        String[] myClass = StringUtils.splitByWholeSeparator( this.getClass().toString(), ".");
        return myClass[myClass.length-1];
    }
    public String getName() {
        return name;
    }


    public Indicador getIndicador() {
        return indicador;
    }


    public int getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }

}
