package model.Condicion.Prioridad;


import model.Empresa;
import model.Indicador;
import model.Resultado;
import org.uqbar.commons.utils.Observable;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@Observable
public class CondicionDecreciente extends CondicionCreciente {

	public CondicionDecreciente(String name, Indicador indicador, int cantidadDePeriodos){
		this.name = name;
		this.indicador = indicador;
		this.cantidadDePeriodos = cantidadDePeriodos;
	}

	@Override
	public void aplicar() {
		 super.aplicar();
		 Resultado.getInstance().getResultadoEmpresas();
		 List<Empresa> StreamInvertido = Resultado.getInstance().getResultadoEmpresas().collect(Collectors.toList());
		 Collections.reverse(StreamInvertido);
		 Resultado.getInstance().setResultadoEmpresas( StreamInvertido.stream());
	}

}