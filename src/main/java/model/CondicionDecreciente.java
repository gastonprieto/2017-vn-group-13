package model;


import org.uqbar.commons.utils.Observable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Observable
public class CondicionDecreciente extends CondicionCreciente {

	public CondicionDecreciente(String name, Indicador indicador, int cantidadDePeriodos){
		this.name = name;
		this.indicador = indicador;
		this.cantidadDePeriodos = cantidadDePeriodos;
	}

	/*@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
		return S
				streamEmpresas.sorted((empresa1, empresa2) ->
				Double.compare(indicador.aplicar(empresa2, periodos), indicador.aplicar(empresa1, periodos)));
	}*/

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		 Stream<Empresa> algo = super.aplicar(streamEmpresas);
		 List<Empresa> esto = algo.collect(Collectors.toList());
		 Collections.reverse(esto);
		 return  esto.stream();
	}

	private int Comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos){
		return  Double.compare(indicador.aplicar(empresa1, periodos), indicador.aplicar(empresa2, periodos));
	}
}