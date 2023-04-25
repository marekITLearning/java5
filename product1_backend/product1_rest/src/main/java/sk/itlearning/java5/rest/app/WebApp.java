package sk.itlearning.java5.rest.app;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("api")
public class WebApp extends Application {

//	@Override
//	public Set<Class<?>> getClasses() {
//		final Set<Class<?>> resources = new HashSet<Class<?>>();
//		resources.add(ImdbData.class);
//		resources.add(CorsFilterProvider.class);
//		resources.add(ExceptionMapperProvider.class);
//		return resources;
//	}

}
