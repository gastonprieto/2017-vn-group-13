package model;

import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

import java.util.List;

public class Metodologia {
	
	private String nombre;
	private CondicionPrioritaria condicionPrioritaria;
	private CondicionTaxativa condicionTaxativa;
	
	public Metodologia(String nombre, CondicionPrioritaria condicionPrioritaria, CondicionTaxativa condicionTaxativa) {
		this.nombre = nombre;
		this.condicionPrioritaria = condicionPrioritaria;
		this.condicionTaxativa = condicionTaxativa;
	}
	
	public List<Empresa> evaluar(List<Empresa> empresas) {
		return this.ordenar(this.filtrar(empresas));
	}
	
	public List<Empresa> filtrar(List<Empresa> empresas) {
		if(this.condicionTaxativa != null)
			return this.condicionTaxativa.filtrar(empresas);
		return empresas;
	}
	
	public List<Empresa> ordenar(List<Empresa> empresas) {
		if(this.condicionPrioritaria != null)
			return this.condicionPrioritaria.ordenar(empresas);
		return empresas;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
