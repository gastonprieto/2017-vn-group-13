package model;

import org.uqbar.commons.utils.Observable;

import java.util.Collection;
import java.util.stream.Stream;

@Observable
public class CondicionCreciente extends CondicionPrioridad {

    public CondicionCreciente(String name, Indicador indicador, int cantidadDePeriodos){
        this.name = name;
        this.indicador = indicador;
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

    @Override
    public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
        Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
        return streamEmpresas.sorted((empresa1, empresa2) ->
                Double.compare(indicador.aplicar(empresa2, periodos), indicador.aplicar(empresa1, periodos)));
    }

	@Override
	public Indicador getIndicador() {
		return this.indicador;
	}
}
