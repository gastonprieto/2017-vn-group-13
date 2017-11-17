package controller;

import java.util.HashMap;
import java.util.Map;

import exception.IndicadorException;
import model.Empresa;
import model.Indicador;
import model.Periodo;
import repositorios.RepositorioDeEmpresas;
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
				.registrarIndicador(interpretadorDeIndicadores.interpretar(req.queryParams("nombre"),
						req.queryParams("calculo")), req.session().attribute("user"));
			res.redirect("/success");
		} catch(IndicadorException e) {
			res.redirect("/error");
		}
		return null;
	}

	public static ModelAndView aplicar(Request req, Response res) {
		Map<String, Object> model = new HashMap<>();
		model.put("indicadores", RepositorioDeIndicadores.getInstance().buscarTodos(req.session().attribute("user")));
		model.put("empresas", RepositorioDeEmpresas.getInstance().buscarTodas());
		return new ModelAndView(model, "Indicadores.hbs");

	}

	public static ModelAndView aplicarIndicador(Request req, Response res) {
		Map<String, Object> model = new HashMap<>();
		model.put("indicadores", RepositorioDeIndicadores.getInstance().buscarTodos(req.session().attribute("user")));
		model.put("empresas", RepositorioDeEmpresas.getInstance().buscarTodas());
		if(req.queryParams("empresa") != null && req.queryParams("indicador") != null &&
				req.queryParams("year") != null && req.queryParams("semester") != null) {
			Periodo periodo = new Periodo();
			periodo.setYear(Integer.parseInt(req.queryParams("year")));
			periodo.setSemester(Integer.parseInt(req.queryParams("semester")));
			Indicador indicador = RepositorioDeIndicadores.getInstance().buscarIndicadorPorId(Long.parseLong(req.queryParams("indicador")));
			Empresa empresa = RepositorioDeEmpresas.getInstance().buscarEmpresaPorId(Long.parseLong(req.queryParams("empresa")));
			try {
				double resultado = indicador.aplicar(empresa, periodo, req.session().attribute("user"));
				model.put("resultado", resultado);
				return new ModelAndView(model, "Indicadores.hbs");
			} catch(RuntimeException e) {
				e.printStackTrace();
			}
		}
		model.put("noResult", true);
		return new ModelAndView(model, "Indicadores.hbs");
	}
}
