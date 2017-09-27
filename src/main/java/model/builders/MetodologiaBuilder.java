package model.builders;

import org.apache.commons.lang.StringUtils;

import exception.BuilderException;
import model.Metodologia;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

public class MetodologiaBuilder {

	private String name;
	private CondicionTaxativa condicionTaxativa;
	private CondicionPrioritaria condicionPrioritaria;
	private boolean existeCondicionPrioritaria = false;
	
	public MetodologiaBuilder(String name) {
		if(StringUtils.isEmpty(name))
			throw new BuilderException("Debe ingresar un nombre");
		this.name = name;
	}
	
	public void agregarCondicionTaxativa(CondicionTaxativa nuevaCondicionTaxativa) {
		if(condicionTaxativa != null) {
			CondicionTaxativa ultimaCondicionTaxativa = this.condicionTaxativa;
			nuevaCondicionTaxativa.setSiguienteCondicion(ultimaCondicionTaxativa);
		}
		this.condicionTaxativa = nuevaCondicionTaxativa;
	}
	
	public void agregarCondicionPrioritaria(CondicionPrioritaria nuevaCondicionPrioritaria) {
		if(existeCondicionPrioritaria) {
			CondicionPrioritaria ultimaCondicionPrioritaria = this.condicionPrioritaria;
			while(ultimaCondicionPrioritaria.getCondicionDesempate() != null) {
				ultimaCondicionPrioritaria = ultimaCondicionPrioritaria.getCondicionDesempate();
			}
			ultimaCondicionPrioritaria.setCondicionDesempate(nuevaCondicionPrioritaria);
		} else {
			this.condicionPrioritaria = nuevaCondicionPrioritaria;
			this.existeCondicionPrioritaria = true;
		}
	}
	
	public Metodologia build() {
		return new Metodologia(name, condicionPrioritaria, condicionTaxativa);
	}
}
