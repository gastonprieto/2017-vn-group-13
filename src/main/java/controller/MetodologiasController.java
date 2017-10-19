package controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView listar(Request req, Response res) {
		// Pagina de metodologias sin nada seleccionado
		return new ModelAndView(null, "Metodologias.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res) {
		// Pagina de metodologias con una metodolgia aplicada
		return new ModelAndView(null, "Metodologias.hbs");
	}
}
