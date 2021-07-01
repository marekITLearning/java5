package sk.itlearning.java5.conf.util;

import com.google.gson.GsonBuilder;

public class JsonUtil {

	public static String toJson(Object o) {
		return new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(o);
	}

}
