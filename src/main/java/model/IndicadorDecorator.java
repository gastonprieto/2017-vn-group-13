package model;

public abstract class IndicadorDecorator implements IndicadorAbstracto {
	
	protected Indicador indicador;
	
	@Override
	public String getNombre() {
		return indicador.getNombre();
	}

}
