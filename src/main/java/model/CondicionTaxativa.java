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

    public void setName(String name) {
        this.name = name;
    }

    public double getValorDeReferencia() {
        return valorDeReferencia;
    }

    public Calculo getCalculo() {
        return calculo;
    }

    public void setCantidadDePeriodos(int cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

    public int getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }
    
    public String getInformacion() {
    	return name + ", " +  getClass().getName() + ", " + calculo.getClass().getSimpleName() + ", " + calculo.getIndicador().getNombre() + ", " + valorDeReferencia + ", " + cantidadDePeriodos ;
    }
}
