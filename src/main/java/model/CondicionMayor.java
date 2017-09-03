package model;


import Converts.ConversorYearToPeriodos;
import org.uqbar.commons.utils.Observable;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by rapap on 27/07/2017.
 */
@Observable
public class CondicionMayor extends CondicionTaxativa{

    public CondicionMayor(){}

    public CondicionMayor(String name, double valorDeReferencia,  int cantidadDePeriodos, Calculo calculo) {
        this.name = name;
        this.valorDeReferencia = valorDeReferencia;
      this.cantidadDePeriodos = cantidadDePeriodos;
        this.calculo = calculo;
    }

    @Override
    public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
        Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
        return streamEmpresas.filter(empresa -> this.calculo.aplicar(empresa, periodos) > valorDeReferencia);
    }

}
