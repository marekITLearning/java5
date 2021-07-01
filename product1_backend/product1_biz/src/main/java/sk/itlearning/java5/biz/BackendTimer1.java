package sk.itlearning.java5.biz;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.inject.Inject;

import sk.itlearning.java5.pers.service.TitleService;

@Singleton
@Startup
public class BackendTimer1 {

	@Resource
	private TimerService timerService;

	@Inject
	private TitleService titleService;

	@PostConstruct
	public void initialize() {
		timerService.createTimer(5000, "ONE_TIME_STARTUP_TIMER");
	}

	@Timeout
	private void doBackendTask1() {
		System.out.println("Starting the backend task 1 ...");
		System.out.println(titleService);
	}

}
