package model;

import java.util.Collection;
import java.util.stream.Stream;

public class CondicionCreciente extends CondicionPrioridad {

    public CondicionCreciente(Indicador indicador, Collection<Periodo> periodos){
        this.indicador = indicador;
        this.periodos = periodos;
    }

    public CondicionCreciente(Indicador indicador, int cantPeriodos){
        this.indicador = indicador;
        ConversorYearToPeriodos Conversor = new ConversorYearToPeriodos(cantPeriodos);
        this.periodos = Conversor.Convertir();
    }

    @Override
    public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
        return streamEmpresas.sorted((empresa1, empresa2) ->
                Double.compare(indicador.aplicar(empresa2, periodos), indicador.aplicar(empresa1, periodos)));
    }
}
