package controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresController {
	public ModelAndView nuevo(Request req, Response res) {
		// Pagina de creacion de indicadores
		return new ModelAndView(null, "NuevoIndicador.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res) {
		// Pagina de aplicar indicadores
		return new ModelAndView(null, "Indicadores.hbs");
	}
}
