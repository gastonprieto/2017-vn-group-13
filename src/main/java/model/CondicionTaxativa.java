package model;

import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionTaxativa implements Condicion{

    protected double valorDeReferencia;
    protected Indicador indicador;
    protected Collection<Periodo> periodos;

}
