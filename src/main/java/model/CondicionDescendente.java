package model;

import java.util.stream.Stream;

public class CondicionDescendente implements Condicion  {
	private double valorDeReferencia;
	private Indicador indicador;
	
	public CondicionDescendente(double valorDeReferencia, ...) {
		this.valorDeReferencia = valorDeReferencia;
	}
	
	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		return streamEmpresas.filter(p -> indicador.aplicar(p) > valorDeReferencia);
	}
}
