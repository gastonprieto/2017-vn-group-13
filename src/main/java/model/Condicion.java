package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import com.ibm.icu.util.Calendar;

public abstract class Condicion {
	
	protected Indicador indicador;
	protected Collection<Periodo> periodos;
	
	public abstract Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas);
	
	protected Collection<Periodo> getPeriodos(int cantidad) {
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
