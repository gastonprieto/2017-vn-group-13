package model;

import org.uqbar.commons.utils.Observable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Observable
public class CondicionMenor extends CondicionMayor  {

	public CondicionMenor(String name, double valorDeReferencia, int cantidadDePeriodos, Calculo calculo) {
		this.name = name;
		this.valorDeReferencia = valorDeReferencia;
		this.cantidadDePeriodos = cantidadDePeriodos;
		this.calculo = calculo;
	}

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		/*En teoria el choclo de abajo, hace la diferencia entre las empresas de streamEmpresa y super.aplicar(streamEmpresa) de condicionMayor.
		* Como no esta hecho el test de esta condicion, no puedo confirmar que funciona. Acepto sugerencias para mejorar esta cosa
		* fea.*/
		return  streamEmpresas.filter(empresa ->  super.aplicar(streamEmpresas).anyMatch( empresa2 -> empresa.equals(empresa))); // Aca hay que hacer la diferencia entre streamEmpresas y el Super.
	}


}
