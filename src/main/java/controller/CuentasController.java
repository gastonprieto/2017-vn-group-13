package controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CuentasController {
	public ModelAndView listar(Request req, Response res) {
		// Tiene que mostrar la pagina de ver cuentas sin nada seleccionado
		return new ModelAndView(null, "VerCuentas.hbs");
	}
	
	public ModelAndView mostrar(Request req, Response res) {
		// Se llama cuando se selecciona una empresa, tiene que mostrar las cuentas de esa empresa
		return new ModelAndView(null, "VerCuentas.hbs");
	}
}
