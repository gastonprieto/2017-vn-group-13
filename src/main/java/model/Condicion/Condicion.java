package model.Condicion;
import model.Calculo.Calculo;
import model.Indicador;
/**
 * Created by rapap on 04/09/2017.
 */
public interface Condicion {
    public abstract void  aplicar();

    public String getName();
    public int getCantidadDePeriodos();
    public Calculo getCalculo();
    public Indicador getIndicador();
    public Double getValorDeReferencia();
}
