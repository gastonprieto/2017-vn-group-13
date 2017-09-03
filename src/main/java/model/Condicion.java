package model;

import java.util.stream.Stream;

public interface  Condicion {

	public  void setName(String name);

	public String getName();
	public Indicador getIndicador();
	public Calculo getCalculo();
	public Integer getCantidadDePeriodos();
	public Double getValorDeReferencia();

	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas);	

}
