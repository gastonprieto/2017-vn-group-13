package model;

import java.util.stream.Stream;

public class CondicionMenor implements Condicion  {
	private double valorDeReferencia;
	private Indicador indicador;
	
	public CondicionMenor(double valorDeReferencia, Indicador indicador) {
		this.valorDeReferencia = valorDeReferencia;
		this.indicador = indicador;
	}
	
	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas, Periodo periodo) {
		return streamEmpresas.filter(empresa -> indicador.aplicar(empresa, periodo) < valorDeReferencia);
	}
}
