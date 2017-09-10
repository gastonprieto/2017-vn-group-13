package model.Condicion.Prioridad;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formasDeAplicacion.FormaAplicacion;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CondicionPrioritaria  {
	
	private Indicador indicador;
	private CondicionPrioritaria condicionDesempate;
	private FormaAplicacion formaAplicacion;
	
	public List<Empresa> ordenar(List<Empresa> empresas) {
		return empresas.stream().sorted((empresa1, empresa2) -> this.realizarComparacion(empresa1, empresa2)).collect(Collectors.toList());
	}
	
	public int realizarComparacion(Empresa empresa1, Empresa empresa2) {
		int resultado = this.formaAplicacion.aplicar(this, empresa1, empresa2);
		if(resultado == 0 && condicionDesempate != null) {
			return condicionDesempate.realizarComparacion(empresa1, empresa2);
		}
		return resultado;
	}
	
	public abstract int comparar(Empresa empresa1, Empresa empresa2);
	
//    protected String name;
//    protected Indicador indicador;
//    protected int cantidadDePeriodos;
//
//
//    public abstract int comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos);
//
//    public String getClassClean(){
//        String[] myClass = StringUtils.splitByWholeSeparator( this.getClass().toString(), ".");
//        return myClass[myClass.length-1];
//    }
//    public String getName() {
//        return name;
//    }
//
//
//    public Indicador getIndicador() {
//        return indicador;
//    }
//
//
//    public int getCantidadDePeriodos() {
//        return cantidadDePeriodos;
//    }

}
