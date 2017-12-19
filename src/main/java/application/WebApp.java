package application;

import spark.servlet.SparkApplication;

public class WebApp implements SparkApplication {

    @Override
    public void init() {
		Router.configure();
    }
}
