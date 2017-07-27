package model;

import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.Collection;

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

	public void registrarMetodologia(Metodologia metodologia) {
		this.metodologias.add(metodologia);
	}
    
    public Collection<Metodologia> getMetodologias() {
        return metodologias;
    }
}
