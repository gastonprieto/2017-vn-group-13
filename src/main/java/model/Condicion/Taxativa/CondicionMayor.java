package model.Condicion.Taxativa;


import utils.Converts.ConversorYearToPeriodos;
import model.Resultado;
import org.uqbar.commons.utils.Observable;
import model.Periodo;
import java.util.Collection;
import model.Calculo.Calculo;

/**
 * Created by rapap on 27/07/2017.
 */
@Observable
public class CondicionMayor extends CondicionTaxativa {

    public CondicionMayor(){}

    public CondicionMayor(String name, double valorDeReferencia,  int cantidadDePeriodos, Calculo calculo) {
        this.name = name;
        this.valorDeReferencia = valorDeReferencia;
        this.cantidadDePeriodos = cantidadDePeriodos;
        this.calculo = calculo;
    }


    public void aplicar() {
        Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
        Resultado.getInstance().getResultadoEmpresas().filter(empresa -> this.calculo.aplicar(empresa, periodos) > valorDeReferencia);
    }



}
