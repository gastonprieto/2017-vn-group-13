package viewmodel;

import model.Empresa;
import model.RepositorioDeEmpresas;
import org.uqbar.commons.utils.Observable;

import java.util.Collection;

/**
 * Created by rapap on 02/07/2017.
 */
@Observable
public class VentanaMetodologiaViewModel {
    private Empresa empresaSeleccionada;

    public Collection<Empresa> getEmpresas(){
        return RepositorioDeEmpresas.getInstance().getEmpresas();
    }

    public Empresa getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {this.empresaSeleccionada = empresaSeleccionada;}
}
