package model;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionPrioridad implements Condicion{
    protected String name;
    protected Indicador indicador;
    protected int cantidadDePeriodos;
    protected Calculo calculo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }

    public void setCantidadDePeriodos(int cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }
}
