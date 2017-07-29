package model;

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

	@Override
	protected Condicion CrearCondicion() {
		if (this.tipoCondicionPrioridad == "Creciente")
			return new CondicionCreciente(name, indicador, cantidadDePeriodos);
		else if (this.tipoCondicionPrioridad == "Decreciente")
			return new CondicionDecreciente(name, indicador, cantidadDePeriodos);
		else if (this.tipoCondicionPrioridad == "Maximizar")
			return new CondicionMaximizar(name, indicador, cantidadDePeriodos);
		
		return null;
	}
	
}
