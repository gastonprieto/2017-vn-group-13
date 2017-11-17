package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exception.IndicadorException;
import model.Indicador;
import model.Periodo;
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
		Map<String, Collection<Indicador>> model = new HashMap<>();
		model.put("indicadores", RepositorioDeIndicadores.getInstance().buscarTodos());
		//Map<String, Collection<Empresa>> model = new HashMap<>();
		//model.put("empresas", RepositorioDeEmpresas.getInstance().buscarTodas());
		return new ModelAndView(model, "Indicadores.hbs");

	}
	public static ModelAndView aplicarIndicador(Request req, Response res) {
		//System.out.println(req);
		Periodo periodo = new Periodo();
		periodo.setYear(Integer.parseInt(req.queryParams("year")));
		periodo.setSemester(Integer.parseInt(req.queryParams("semester")));
		RepositorioDeIndicadores.getInstance().buscarIndicador(req.queryParams("myselect"));
		return null;
	}
}
