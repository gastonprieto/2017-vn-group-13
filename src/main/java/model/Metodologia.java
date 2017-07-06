package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Metodologia {

    public String nombre;
    //public Condicion condicion;
    Collection<Condicion> condiciones = new ArrayList<>();

    public Metodologia(String _nombre, Condicion _condicion){
        this.nombre = _nombre;
        this.condicion = _condicion;
    }
	
	public ArrayList<Empresa> evaluar(Collection<Empresa> empresas) {
		Stream<Empresa> streamEmpresas = empresas.stream();
		for(Condicion condicion : condiciones) {
			streamEmpresas = condicion.aplicar(streamEmpresas);
		}
		return (ArrayList<Empresa>) streamEmpresas.collect(Collectors.toList());		
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }


}
