package application;

import controller.CuentasController;
import controller.HomeController;
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
		Spark.get("/empresas", CuentasController::listar, engine);
	}
}
