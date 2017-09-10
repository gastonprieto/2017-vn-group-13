package model.Calculo;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;

public abstract class Calculo {
	
	protected Indicador indicador;
	
	public Calculo(Indicador indicador) {
		this.indicador = indicador;
	}
	
	public Indicador getIndicador() {
        return this.indicador;
    }
		
	public abstract Double aplicar(Empresa empresa, Periodo periodo);
	public abstract Double aplicar(Empresa empresa, Collection<Periodo> periodos);

	public String getClassClean(){
		String[] myClass = StringUtils.splitByWholeSeparator( this.getClass().toString(), ".");
		return myClass[myClass.length-1];
	}
}
