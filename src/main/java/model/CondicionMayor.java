package model;


import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by rapap on 27/07/2017.
 */
public class CondicionMayor extends CondicionTaxativa{

    public CondicionMayor(double valorDeReferencia, Indicador indicador, Collection<Periodo> periodos) {
        this.valorDeReferencia = valorDeReferencia;
        this.indicador = indicador;
        this.periodos = periodos;
    }

    public CondicionMayor(Indicador indicador, int cantPeriodos){
        this.indicador = indicador;
       // this.periodos = this.getPeriodos(cantPeriodos);
    }

    @Override
    public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
        return streamEmpresas.filter(empresa -> indicador.aplicar(empresa, periodos) > valorDeReferencia);
    }
}
