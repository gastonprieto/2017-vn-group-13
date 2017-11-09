package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Empresa;
import repositorios.RepositorioDeEmpresas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CuentasController {
	
	public static ModelAndView listar(Request req, Response res) {
		Map<String, Collection<Empresa>> model = new HashMap<>();
		model.put("empresas", RepositorioDeEmpresas.getInstance().buscarTodas());
		return new ModelAndView(model, "VerCuentas.hbs");
	}
	
	public static ModelAndView mostrar(Request req, Response res) {
		Map<String, Object> model = new HashMap<>();
		model.put("empresas", RepositorioDeEmpresas.getInstance().buscarTodas());
		model.put("cuentas", RepositorioDeEmpresas.getInstance().buscarCuentasPorEmpresa(Long.parseLong(req.params("id"))));
		return new ModelAndView(model, "VerCuentas.hbs");
	}
}
