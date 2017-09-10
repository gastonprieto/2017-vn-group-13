package model.Condicion.Prioridad;


import model.Indicador;
import org.apache.commons.lang.StringUtils;

/**
 * Created by rapap on 27/07/2017.
 */


public abstract class CondicionPrioridad  {
    protected String name;
    protected Indicador indicador;
    protected int cantidadDePeriodos;


    public abstract void aplicar();

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
