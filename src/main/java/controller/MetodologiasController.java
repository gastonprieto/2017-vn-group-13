package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Metodologia;
import repositorios.RepositorioDeEmpresas;
import repositorios.RepositorioDeMetodologias;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	
	public static ModelAndView aplicar(Request req, Response res) {
		Map<String, Object> model = new HashMap<>();
		model.put("metodologias", RepositorioDeMetodologias.getInstance().buscarTodas(req.session().attribute("user")));
		Metodologia metodologia = RepositorioDeMetodologias.getInstance().buscarMetodologia(Long.parseLong(req.params("id")));
		if(metodologia != null)
			model.put("empresas", metodologia.evaluar(RepositorioDeEmpresas.getInstance().buscarTodas()));
		return new ModelAndView(model, "AplicarMetodologias.hbs");
	}
	
	public static ModelAndView listar(Request req, Response res) {
		Map<String, Collection<Metodologia>> model = new HashMap<>();		
		model.put("metodologias", RepositorioDeMetodologias.getInstance().buscarTodas(req.session().attribute("user")));		
		return new ModelAndView(model, "AplicarMetodologias.hbs");
	}
}
