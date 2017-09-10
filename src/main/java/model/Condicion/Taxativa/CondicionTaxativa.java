package model.Condicion.Taxativa;


import model.Calculo.Calculo;
import model.Condicion.Condicion;
import model.Indicador;
import org.apache.commons.lang.StringUtils;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionTaxativa  {

    protected  String name;
    protected int cantidadDePeriodos;
    protected Double valorDeReferencia;
    protected Calculo calculo;


    public String getName() {
        return name;
    }

    public String getClassClean(){
        String[] myClass = StringUtils.splitByWholeSeparator( this.getClass().toString(), ".");
        return myClass[myClass.length-1];
    }

    public int getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }


    public Double getValorDeReferencia() {
        return valorDeReferencia;
    }


    public Calculo getCalculo() {
        return calculo;
    }


    public Indicador getIndicador() {
        return null;
    }
}
