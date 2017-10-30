package application;

import controller.CuentasController;
import controller.HomeController;
import controller.IndicadoresController;
import controller.MetodologiasController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
	
	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.build();
		
		Spark.staticFiles.location("/public");

		Spark.get("/", HomeController::home, engine);
		Spark.get("/success", HomeController::success, engine);
		Spark.get("/error", HomeController::error, engine);
		
		CuentasController cuentasController = new CuentasController();
		Spark.get("/empresas", cuentasController::listar, engine);
		Spark.get("/empresas/:id/cuentas", cuentasController::mostrar, engine);
		
		IndicadoresController indicadoresController = new IndicadoresController();
		Spark.get("/indicadores/nuevo", indicadoresController::nuevo, engine);
		Spark.post("/indicadores/nuevo", indicadoresController::guardar);
		Spark.get("/indicadores/aplicar", indicadoresController::aplicar, engine);
		
		MetodologiasController metodologiasController = new MetodologiasController();
		Spark.get("/metodologias", metodologiasController::listar, engine);
		Spark.get("/metodologias/:id/aplicar", metodologiasController::aplicar, engine);
	}
}
