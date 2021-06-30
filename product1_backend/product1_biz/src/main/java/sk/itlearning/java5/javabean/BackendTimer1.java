package sk.itlearning.java5.javabean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

@Singleton
@Startup
public class BackendTimer1 {
	
	@Resource private TimerService timerService;
	
	@PostConstruct
	public void initialize() {
		timerService.createTimer(5000, "Every 5 seconds timer");
	}

	@Timeout
	private void doBackendTask1() {
		System.out.println("Starting the backend task 1 ...");
	}
    
}
