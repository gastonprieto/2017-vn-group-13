package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import Converts.ConversorYearToPeriodos;
import com.ibm.icu.util.Calendar;

/**
 * Created by rapap on 27/07/2017.
 */
public class CondicionMaximizar extends CondicionPrioridad {
  
	public CondicionMaximizar(String name, Indicador indicador, int cantidadDePeriodos){
        this.name = name;
        this.indicador = indicador;
        this.cantidadDePeriodos = cantidadDePeriodos;
    }

    public CondicionMaximizar(Indicador indicador, int cantPeriodos){
        this.indicador = indicador;
        ConversorYearToPeriodos Conversor = new ConversorYearToPeriodos(cantPeriodos);
        this.cantidadDePeriodos = cantPeriodos;
    }

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {								
		return streamEmpresas.sorted((empresa1, empresa2) -> comparar(empresa1, empresa2));
	}
	
	public Integer comparar(Empresa empresa1, Empresa empresa2) {
		Collection<Double> roe1 = new ArrayList<>();
		Collection<Double> roe2 = new ArrayList<>();
		Integer mejor = 1;
		
		for(int i = 10; i > 0; i --) {
			for(int j = 1; j < 3; i ++) {
				int year = Calendar.getInstance().get(Calendar.YEAR - i);
				int semester = j;
				roe1.add(indicador.aplicar(empresa1, new Periodo(year, semester)));
				roe2.add(indicador.aplicar(empresa1, new Periodo(year, semester)));				
			}			
		}
		
		for (Double i1 : roe1) {
			for (Double i2 : roe2) {
				if (i1 < i2) {
					mejor = -1;					
				}
			}
		}		
		return mejor;		
	}

	@Override
	public Indicador getIndicador() {		
		return this.indicador;
	}
}
