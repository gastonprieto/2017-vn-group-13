package model;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by rapap on 23/07/2017.
 */
public interface CondicionInterfaz {

    public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas);
    public Collection<Periodo> getPeriodos(int cantidad);
}
