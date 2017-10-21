package model.formas.de.aplicacion;

import model.formas.de.aplicacion.AplicacionSimple;;

public enum FormaAplicacionEnum {
	APLICACION_SIMPLE {
		@Override
		public FormaAplicacion getInstance() {
			return AplicacionSimple.getInstance();
		}
	},
	APLICACION_POR_SUMATORIA {
		@Override
		public FormaAplicacion getInstance() {
			return AplicacionPorSumatoria.getInstance();
		}
	},
	APLICACION_POR_PROMEDIO {
		@Override
		public FormaAplicacion getInstance() {
			return AplicacionPorPromedio.getInstance();
		}
	},
	APLICACION_POR_MEDIANA {
		@Override
		public FormaAplicacion getInstance() {
			return AplicacionPorMediana.getInstance();
		}
	},
	APLICACION_POR_CONSISTENCIA {
		@Override
		public FormaAplicacion getInstance() {
			return AplicacionPorConsistencia.getInstance();
		}
	};
	
	public abstract FormaAplicacion getInstance();
}
