package sk.itlearning.java5.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * This class is needed for bootstrapping the REST resources.
 * 
 * Here you define a prefix for all endpoints. The prefix is named by convention
 * typically as 'api', 'rest' or 'resources'.
 * 
 */
@ApplicationPath("api")
public class MyApplication extends Application {

}
