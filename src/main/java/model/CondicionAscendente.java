package model;

import java.util.stream.Stream;

public class CondicionAscendente implements Condicion  {
	
	private Indicador indicador;
	
	public CondicionAscendente(Indicador indicador){
		this.indicador = indicador;
	}
	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas, Periodo periodo) {
		return streamEmpresas.sorted((empresa1,empresa2)-> Double.compare(indicador.aplicar(empresa2,periodo), indicador.aplicar(empresa1, periodo)));

	}	
}
