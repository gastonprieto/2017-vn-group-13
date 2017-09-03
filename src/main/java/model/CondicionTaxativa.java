package model;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionTaxativa implements Condicion{
    protected String name;
    protected double valorDeReferencia;
    protected Calculo calculo;
    protected int cantidadDePeriodos;


    public String getName() {
        return name;
    }
    public Integer getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }
    public Indicador getIndicador(){return null;}
    public Calculo getCalculo() {
        return calculo;
    }
    public Double getValorDeReferencia() {
        return valorDeReferencia;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCantidadDePeriodos(int cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

}
