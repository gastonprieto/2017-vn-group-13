package model;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionPrioridad implements Condicion{
    protected String name;
    protected Indicador indicador;
    protected int cantidadDePeriodos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public Indicador getIndicador() {
        return this.indicador;
    }

    public int getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }

    public void setCantidadDePeriodos(int cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }  
    
    public String getInformacion() {
    	return  name + ", " +  getClass().getName() + ", " + indicador.getNombre() + ", " + cantidadDePeriodos ;
    }
}
