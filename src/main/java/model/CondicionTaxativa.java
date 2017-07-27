package model;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionTaxativa implements Condicion{
    protected String name;
    protected double valorDeReferencia;
    protected Indicador indicador;
    protected Collection<Periodo> periodos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
