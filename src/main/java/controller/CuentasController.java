package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Repositorio.RepositorioDeEmpresas;
import model.Empresa;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CuentasController {
	public ModelAndView listar(Request req, Response res) {
		Map<String, Collection<Empresa>> model = new HashMap<>();
		model.put("empresas", RepositorioDeEmpresas.getInstance().buscarTodas());
		return new ModelAndView(model, "VerCuentas.hbs");
	}
	
	public ModelAndView mostrar(Request req, Response res) {
		// Se llama cuando se selecciona una empresa, tiene que mostrar las cuentas de esa empresa
		return new ModelAndView(null, "VerCuentas.hbs");
	}
}
