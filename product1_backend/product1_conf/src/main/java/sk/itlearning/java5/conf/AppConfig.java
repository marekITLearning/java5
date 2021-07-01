package sk.itlearning.java5.conf;

public class AppConfig {

//	private static final String configFilePath;

	public static final String hostUrl;

	public static final String prodEnvironment;

	static {
		hostUrl = System.getProperty("hostUrl", "http://localhost:8088/");
		prodEnvironment = System.getProperty("prodEnvironment", "false");
	}

	public static boolean isProdEnvironment() {
		return prodEnvironment.equalsIgnoreCase("true");
	}

}
