package sk.itlearning.java5.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import sk.itlearning.java5.rest.endpoints.ImdbData;

@ApplicationPath("api")
public class WebApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(ImdbData.class);
		resources.add(CorsFilterProvider.class);
		resources.add(ExceptionMapperProvider.class);
		return resources;
	}

}
