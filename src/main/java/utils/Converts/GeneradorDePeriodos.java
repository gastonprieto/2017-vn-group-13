package utils.Converts;

import com.ibm.icu.util.Calendar;
import model.Periodo;

import java.util.ArrayList;
import java.util.Collection;

public class GeneradorDePeriodos {

    public static Collection<Periodo> generarPeriodos(int cantPeriodos) {
        Collection<Periodo> periodos = new ArrayList<>();
        int year = Calendar.getInstance().get(Calendar.YEAR) ;
        int semester = (Calendar.getInstance().get(Calendar.MONTH) / 6) + 1;
        for(int i = 0; i < cantPeriodos; i ++) {
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
