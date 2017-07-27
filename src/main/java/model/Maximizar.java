package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import com.ibm.icu.util.Calendar;

public class Maximizar implements CondicionInterfaz {
	
	protected Indicador indicador;
	protected Collection<Periodo> periodos;
	
	public Maximizar(Indicador indicador, Collection<Periodo> periodos){
		this.indicador = indicador;
		this.periodos = periodos;
	}

	public Maximizar(Indicador indicador, int cantPeriodos){
		this.indicador = indicador;
		this.periodos = this.getPeriodos(cantPeriodos);
	}

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		Collection<Double> roe = new ArrayList<>();
				
		
		//periodos.add(new Periodo(year, semester));
		//int year = Calendar.getInstance().get(Calendar.YEAR);
		//int semester = (Calendar.getInstance().get(Calendar.MONTH) / 6) + 1;
		
		return streamEmpresas.sorted((empresa1, empresa2) ->
			Double.compare(indicador.aplicar(empresa2, periodos), indicador.aplicar(empresa1, periodos)));
	}
	
	public Boolean comparar(Empresa empresa1, Empresa empresa2) {
		Collection<Double> roe1 = new ArrayList<>();
		Collection<Double> roe2 = new ArrayList<>();
		
		for(int i = 10; i > 0; i --) {
			for(int j = 1; j < 3; i ++) {
				int year = Calendar.getInstance().get(Calendar.YEAR - i);
				int semester = j;
				roe1.add(indicador.aplicar(empresa1, new Periodo(year, semester)));
				roe2.add(indicador.aplicar(empresa1, new Periodo(year, semester)));				
			}			
		}
		
		roe1.stream().filter(r -> p.getAge() > 16).collect(Collectors.toList());
		
		
		
		return null;
		
	}

	@Override
	public Collection<Periodo> getPeriodos(int cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
