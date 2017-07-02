package model;

import java.util.Collection;

/**
 * Created by rapap on 02/07/2017.
 */
public class RepositorioDeMetodologias {
    private static RepositorioDeMetodologias instance = null;
    private Collection<Metodologia> metodologias;

    private RepositorioDeMetodologias() {

    }

    public static RepositorioDeMetodologias getInstance() {
        if(instance == null) {
            instance = new RepositorioDeMetodologias();
        }
        return instance;
    }

    public Collection<Metodologia> getMetodologias() {
        return metodologias;
    }

    public void setMetodologias(Collection<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }

}
