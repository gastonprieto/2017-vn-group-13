package model.Condicion.Taxativa;


import org.uqbar.commons.utils.Observable;
import model.Calculo.Calculo;
import model.Empresa;
import utils.Converts.GeneradorDePeriodos;
import model.Periodo;
import java.util.Collection;
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

    @Override
    public boolean aplicar(Empresa empresa) {
        Collection<Periodo> periodos = new GeneradorDePeriodos(this.cantidadDePeriodos).Convertir();
        return this.calculo.aplicar(empresa, periodos) > valorDeReferencia;
    }

}
