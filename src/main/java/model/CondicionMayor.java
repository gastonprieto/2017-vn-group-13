package model;


import org.uqbar.commons.utils.Observable;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by rapap on 27/07/2017.
 */
@Observable
public class CondicionMayor extends CondicionTaxativa{

    public CondicionMayor(String name, double valorDeReferencia, Indicador indicador, Collection<Periodo> periodos) {
        this.name = name;
        this.valorDeReferencia = valorDeReferencia;
        this.indicador = indicador;
        this.periodos = periodos;
    }

    public CondicionMayor(Indicador indicador, int cantPeriodos){
        this.indicador = indicador;
        ConversorYearToPeriodos Conversor = new ConversorYearToPeriodos(cantPeriodos);
        this.periodos = Conversor.Convertir();
    }

    @Override
    public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
        return streamEmpresas.filter(empresa -> indicador.aplicar(empresa, periodos) > valorDeReferencia);
    }
}
