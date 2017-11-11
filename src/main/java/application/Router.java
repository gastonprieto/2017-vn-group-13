package application;

import controller.CuentasController;
import controller.HomeController;
import controller.IndicadoresController;
import controller.LoginController;
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
		
		Spark.before("/*", LoginController::verificarUsuarioLoggeado);
		
		Spark.get("/login", LoginController::getLogInPage, engine);
		Spark.post("/login", LoginController::logIn, engine);
		Spark.get("/logout", LoginController::logOut, engine);

		Spark.get("/", HomeController::home, engine);
		Spark.get("/success", HomeController::success, engine);
		Spark.get("/error", HomeController::error, engine);
		
		Spark.get("/empresas", CuentasController::listar, engine);
		Spark.get("/empresas/:id/cuentas", CuentasController::mostrar, engine);
		
		Spark.get("/indicadores/nuevo", IndicadoresController::nuevo, engine);
		Spark.post("/indicadores", IndicadoresController::guardar);
		Spark.get("/indicadores/aplicar", IndicadoresController::aplicar, engine);
		
		Spark.get("/metodologias", MetodologiasController::listar, engine);
		Spark.get("/metodologias/:id/aplicar", MetodologiasController::aplicar, engine);
	}
}
