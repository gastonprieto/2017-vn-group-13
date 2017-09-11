package model.condiciones.prioritarias;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formas.de.aplicacion.FormaAplicacion;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CondicionPrioritaria  {
	
	protected Indicador indicador;
	protected CondicionPrioritaria condicionDesempate;
	protected FormaAplicacion formaAplicacion;
	
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
	
	public double aplicarIndicador(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	public abstract int comparar(double resultadoEmpresa1, double resultadoEmpresa2);
	
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
