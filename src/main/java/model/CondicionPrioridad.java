package model;

/**
 * Created by rapap on 27/07/2017.
 */
public abstract class CondicionPrioridad extends Condicion{
    protected String name;
    protected Indicador indicador;
    protected int cantidadDePeriodos;

    public String getName() {
        return name;
    }
    public Indicador getIndicador() {
        return this.indicador;
    }
    public Calculo getCalculo(){return null;}
    public Integer getCantidadDePeriodos() {
        return cantidadDePeriodos;
    }
    public Double getValorDeReferencia(){return  null;}

    public void setName(String name) {
        this.name = name;
    }
    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }
    public void setCantidadDePeriodos(int cantidadDePeriodos) {
        this.cantidadDePeriodos = cantidadDePeriodos;
    }  

}
