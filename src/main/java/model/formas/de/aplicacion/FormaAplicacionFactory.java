package model.formas.de.aplicacion;

public class FormaAplicacionFactory {

	public FormaAplicacion getFormaAplicacion(FormaAplicacionEnum formaAplicacionEnum) {
		if(formaAplicacionEnum == FormaAplicacionEnum.AplicacionSimple)
			return AplicacionSimple.getInstance();
		else if(formaAplicacionEnum == FormaAplicacionEnum.AplicacionPorSumatoria)
			return AplicacionPorSumatoria.getInstance();
		else if(formaAplicacionEnum == FormaAplicacionEnum.AplicacionPorPromedio)
			return AplicacionPorPromedio.getInstance();
		else if(formaAplicacionEnum == FormaAplicacionEnum.AplicacionPorMediana)
			return AplicacionPorMediana.getInstance();
		else
			return AplicacionPorConsistencia.getInstance();
	}
}
