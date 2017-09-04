package model;

import Converts.DatoCompatable;
import exception.FabricaException;

public class FabricaCondicionesDePrioridad extends FabricaCondicion {
	
	protected String name;
    protected Indicador indicador;
    protected int cantidadDePeriodos;
    protected String tipoCondicionPrioridad;
	
	public FabricaCondicionesDePrioridad(String name, Indicador indicador, int cantidadDePeriodos, String tipoCondicionPrioridad){
	        this.name = name;
	        this.indicador = indicador;
	        this.cantidadDePeriodos = cantidadDePeriodos;
	        this.tipoCondicionPrioridad = tipoCondicionPrioridad;
	    }

	public FabricaCondicionesDePrioridad(DatoCompatable nuevaCondicion){
		this.name = nuevaCondicion.getNameCondicion();
		this.indicador = RepositorioDeIndicadores.getInstance().buscarIndicador(nuevaCondicion.getNameIndicador());
		this.cantidadDePeriodos = Integer.parseInt(nuevaCondicion.getCantDePeriodos());
		this.tipoCondicionPrioridad = nuevaCondicion.getClassCondicion();
	}

	@Override
	protected Condicion CrearCondicion() {
		if (this.tipoCondicionPrioridad.equals("Creciente")){
			return new CondicionCreciente(name, indicador, cantidadDePeriodos);
		}else if (this.tipoCondicionPrioridad.equals("Decreciente")) {
			return new CondicionDecreciente(name, indicador, cantidadDePeriodos);
		}else if (this.tipoCondicionPrioridad.equals("Maximizar")) {
			return new CondicionMaximizar(name, indicador, cantidadDePeriodos);
		}else{
			throw new FabricaException("El Tipo de condiciones no corresponde a una Condicion de Prioridad, su valor es :" + this.tipoCondicionPrioridad);
		}
	}
	
}
