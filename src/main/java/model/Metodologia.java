package model;

import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Observable
public class Metodologia {

    public String nombre;
    public Collection<Condicion> condiciones;

    public Metodologia(String nombre, Collection<Condicion> condiciones){
        this.nombre = nombre;
        this.condiciones = condiciones;
    }
	
	public Collection<Empresa> evaluar(Collection<Empresa> empresas) {
		Stream<Empresa> streamEmpresas = empresas.stream();
		for(Condicion condicion : condiciones) {
			streamEmpresas = condicion.aplicar(streamEmpresas);
		}
		return (ArrayList<Empresa>) streamEmpresas.collect(Collectors.toList());		
	}



	public String getNombre() {
        return nombre;
    }
}
