package model;

import java.util.stream.Stream;

/**
 * Created by rapap on 04/09/2017.
 */
public abstract class Condicion {

    protected String Name;
    protected Indicador indicador;
    protected Calculo calculo;
    protected Integer CantDePeriodos;
    protected Double ValorDeReferencia;

    public abstract Stream<Empresa>  aplicar(Stream<Empresa> streamEmpresas);

    public String getName() {
        return Name;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public Calculo getCalculo() {
        return calculo;
    }

    public Integer getCantDePeriodos() {
        return CantDePeriodos;
    }

    public Double getValorDeReferencia() {
        return ValorDeReferencia;
    }

}
