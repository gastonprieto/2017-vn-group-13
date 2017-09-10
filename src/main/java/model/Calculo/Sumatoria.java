package model.Calculo;

import model.Empresa;
import model.Indicador;
import model.Periodo;

import java.util.Collection;

public class Sumatoria extends Calculo {
	
	public Sumatoria(Indicador indicador) {
		super(indicador);
	}
	
	@Override
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	@Override
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		Double sumatoria = 0D;
		Double valor = 0.0;
		for(Periodo periodo : periodos) {
			try{
				valor = this.indicador.aplicar(empresa, periodo);
			}catch (NullPointerException e){
				valor = 0.0;
			}
			sumatoria += valor;
		}
		return sumatoria;
	}

}
