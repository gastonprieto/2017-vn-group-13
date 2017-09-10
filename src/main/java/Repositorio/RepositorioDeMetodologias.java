package Repositorio;


import model.Metodologia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class RepositorioDeMetodologias {
    private static RepositorioDeMetodologias instance = null;
    private Collection<Metodologia> metodologias = new ArrayList<>();

    private RepositorioDeMetodologias() {

    }

    public static RepositorioDeMetodologias getInstance() {
        if(instance == null) {
            instance = new RepositorioDeMetodologias();
        }
        return instance;
    }

    public Metodologia BuscarMetodologia(String nombreMetodologia){
            return  getInstance().getMetodologias().stream().filter(e -> e.getNombre().equals(nombreMetodologia)).findFirst().get();
}

	public void registrarMetodologia(Metodologia metodologia) {
		this.metodologias.add(metodologia);
	}
    
    public Collection<Metodologia> getMetodologias() {
        return metodologias;
    }
}
