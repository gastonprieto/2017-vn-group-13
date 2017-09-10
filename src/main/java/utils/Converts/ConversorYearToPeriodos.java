package utils.Converts;

import com.ibm.icu.util.Calendar;
import model.Periodo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rapap on 27/07/2017.
 */
public class ConversorYearToPeriodos {

    int Cantidad;

    public ConversorYearToPeriodos(int _Cantidad){
        this.Cantidad = _Cantidad ;
    }

    public Collection<Periodo> Convertir() {
        Collection<Periodo> periodos = new ArrayList<>();
        int year = Calendar.getInstance().get(Calendar.YEAR) ;
        int semester = (Calendar.getInstance().get(Calendar.MONTH) / 6) ;//
        for(int i = 0; i < this.Cantidad; i ++) {
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
