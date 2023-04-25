package sk.itlearning.java5.biz.timer;

import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import jakarta.ejb.TimerService;

@Stateless
public class BackendTimer2 {

	@Resource
	private TimerService timerService;

	@Schedule(hour = "*", minute = "*", second = "*/30", info = "SCHEDULED_TIMER")
	private void doBackendTask2() {
		System.out.println("Starting the backend task 2 (repeats every 30 seconds)...");
	}

}
