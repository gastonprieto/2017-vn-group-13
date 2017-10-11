package Repositorio;


import model.Indicador;
import model.Metodologia;
import utils.DB.PersistenciaDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class RepositorioDeMetodologias {
    private static RepositorioDeMetodologias instance = null;
    private Collection<Metodologia> metodologias;

    private RepositorioDeMetodologias() {
        metodologias = new ArrayList<>();
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
        PersistenciaDB persistencia = new PersistenciaDB();
        persistencia.PerisistrMetodologiaDelRepositorio(metodologia);
		this.metodologias.add(metodologia);
	}
    
    public Collection<Metodologia> getMetodologias() {
        return metodologias;
    }
    
    public void setMetodologias(Collection<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}
}
