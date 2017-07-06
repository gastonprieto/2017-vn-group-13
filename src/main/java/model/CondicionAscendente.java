package model;

import java.util.stream.Stream;

public class CondicionAscendente implements Condicion  {
	private double valorDeReferencia;
	private Indicador indicador;
	
	public CondicionAscendente(double valorDeReferencia, ...) {
		this.valorDeReferencia = valorDeReferencia;
	}
	
	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas, Periodo periodo) {
		return streamEmpresas.filter(p -> indicador.aplicar(p) > valorDeReferencia);
	}
}
