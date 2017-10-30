package controller;

import Repositorio.RepositorioDeIndicadores;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import utils.File.InterpretadorDeIndicadores;

public class IndicadoresController {
	public ModelAndView nuevo(Request req, Response res) {	
		return new ModelAndView(null, "NuevoIndicador.hbs");
	}
	
	public Void guardar(Request req, Response res) {
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		RepositorioDeIndicadores.getInstance().registrarIndicador(interpretadorDeIndicadores.interpretar(req.queryParams("nombre"), req.queryParams("calculo")));
		res.redirect("/");
		return null;
	}
	
	public ModelAndView aplicar(Request req, Response res) {
		// Pagina de aplicar indicadores
		return new ModelAndView(null, "Indicadores.hbs");
	}
}
