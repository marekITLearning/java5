package sk.itlearning.java5.conf;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {

	private static final String configFilePath;

	private static final String prodEnvironment;

	static {
		configFilePath = System.getProperty("configFilePath", "../product1_backend_doc/app_config.properties");

		Dotenv dotenv = Dotenv.configure().filename(configFilePath).load();

		prodEnvironment = dotenv.get("prodEnvironment", "false");
	}

	public static boolean isProdEnvironment() {
		return prodEnvironment.equalsIgnoreCase("true");
	}

}
