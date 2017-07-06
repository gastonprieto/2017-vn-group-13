package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Metodologia {

    public String nombre;
    public Condicion condicion;

    public Metodologia(String nombre, Condicion condicion){
        this.nombre = nombre;
        this.condicion = condicion;
    }
	
	public ArrayList<Empresa> evaluar(Collection<Empresa> empresas, Collection<Periodo> periodos) {
		Stream<Empresa> streamEmpresas = empresas.stream();
		streamEmpresas = condicion.aplicar(streamEmpresas, periodos);
		return (ArrayList<Empresa>) streamEmpresas.collect(Collectors.toList());		
	}

    public String getNombre() {
        return nombre;
    }
}
