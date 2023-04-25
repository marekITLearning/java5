package sk.itlearning.java5.conf.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

	public static String toJson(Object o) {
		return gson.toJson(o);
	}

}
