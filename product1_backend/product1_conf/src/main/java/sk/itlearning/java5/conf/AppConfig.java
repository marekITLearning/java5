package sk.itlearning.java5.conf;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {

	private static final String configFilePath;

	public static final String hostUrl;

	private static final String prodEnvironment;

	static {
		configFilePath = System.getProperty("configFilePath", "../product1_backend_doc/app_config.properties");

		Dotenv dotenv = Dotenv.configure().filename(configFilePath).load();

		hostUrl = dotenv.get("hostUrl", "localhost:8088");

		prodEnvironment = dotenv.get("prodEnvironment", "false");
	}

	public static boolean isProdEnvironment() {
		return prodEnvironment.equalsIgnoreCase("true");
	}

}
