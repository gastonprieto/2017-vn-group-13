package controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CuentasController {
	public static ModelAndView listar(Request req, Response res) {
		return new ModelAndView(null, "VerCuentas.hbs");
	}
}
