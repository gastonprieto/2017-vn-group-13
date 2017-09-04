package model;


import exception.CondicionException;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionTaxativa extends Condicion{
    protected String name;
    protected double valorDeReferencia;
    protected Calculo calculo;
    protected int cantidadDePeriodos;


    @Override
    public Indicador getIndicador() {
        throw new CondicionException(this.name, this.getClass().toString(), "indicador");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCantidadDePeriodos(int cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

}
