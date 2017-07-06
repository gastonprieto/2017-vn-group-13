package model;

import java.util.stream.Stream;

public class CondicionMayor implements Condicion  {
	private double valorDeReferencia;
	private Indicador indicador;
	
	public CondicionMayor(double valorDeReferencia, ...) {
		this.valorDeReferencia = valorDeReferencia;
	}
	
	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		return streamEmpresas.filter(p -> indicador.aplicar(p) > valorDeReferencia);
	}
}
