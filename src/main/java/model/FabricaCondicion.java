package model;

/**
 * Created by rapap on 29/07/2017.
 */

public abstract class FabricaCondicion{
	
	public Condicion ObtenerCondicion()
    {
        Condicion condicion = CrearCondicion();
        
        return condicion;
    }
	
	protected abstract Condicion CrearCondicion();
}
