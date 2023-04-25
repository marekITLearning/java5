package sk.itlearning.java5.biz.timer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Timeout;
import jakarta.ejb.TimerService;

@Singleton
@Startup
public class BackendTimer1 {

	@Resource
	private TimerService timerService;

	@PostConstruct
	public void initialize() {
		timerService.createTimer(5000, "ONE_TIME_STARTUP_TIMER");
	}

	@Timeout
	private void doBackendTask1() {
		System.out.println("Starting the backend task 1 ...");
	}

}
