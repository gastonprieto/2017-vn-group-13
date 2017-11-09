package controller;

import exception.IndicadorException;
import repositorios.RepositorioDeIndicadores;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import utils.InterpretadorDeIndicadores;

public class IndicadoresController {
	
	public static ModelAndView nuevo(Request req, Response res) {	
		return new ModelAndView(null, "NuevoIndicador.hbs");
	}
	
	public static ModelAndView guardar(Request req, Response res) {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		try {
			RepositorioDeIndicadores.getInstance()
				.registrarIndicador(interpretadorDeIndicadores.interpretar(req.queryParams("nombre"), req.queryParams("calculo")));
			res.redirect("/success");
		} catch(IndicadorException e) {
			res.redirect("/error");
		}
		return null;
	}
	
	public static ModelAndView aplicar(Request req, Response res) {
		// Pagina de aplicar indicadores
		return new ModelAndView(null, "Indicadores.hbs");
	}
}
