package model.Condicion.Prioridad;

import utils.Converts.ConversorYearToPeriodos;
import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.Resultado;
import org.uqbar.commons.utils.Observable;

import java.util.Collection;

@Observable
public class CondicionCreciente extends CondicionPrioridad {


    public CondicionCreciente(){}

    public CondicionCreciente(String name, Indicador indicador, int cantidadDePeriodos){
        this.name = name;
        this.indicador = indicador;
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

    public void aplicar() {
        Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
         Resultado.getInstance().getResultadoEmpresas().sorted((empresa2, empresa1) -> Comparar(empresa2, empresa1, periodos));
    }

    private int Comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos){
        return  Double.compare(indicador.aplicar(empresa1, periodos), indicador.aplicar(empresa2, periodos));
    }


}
