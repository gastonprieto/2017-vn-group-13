package model;

import com.ibm.icu.util.Calendar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by rapap on 23/07/2017.
 */
public abstract class CondicionDecorador implements CondicionInterfaz{

    protected CondicionInterfaz CondicionComponente;
    protected double valorDeReferencia;
    protected Indicador indicador;
    protected Collection<Periodo> periodos;

    public CondicionDecorador(){}

    public CondicionDecorador(CondicionInterfaz compnente){
        this.CondicionComponente = compnente;
    }

    protected CondicionInterfaz getCondicionComponente(){
        return this.CondicionComponente;
    }

    public Collection<Periodo> getPeriodos(int cantidad) {
        Collection<Periodo> periodos = new ArrayList<>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int semester = (Calendar.getInstance().get(Calendar.MONTH) / 6) + 1;
        for(int i = 0; i < cantidad; i ++) {
            if(semester == 1) {
                semester ++;
                year --;
            } else {
                semester --;
            }
            periodos.add(new Periodo(year, semester));
        }
        return periodos;
    }
}
