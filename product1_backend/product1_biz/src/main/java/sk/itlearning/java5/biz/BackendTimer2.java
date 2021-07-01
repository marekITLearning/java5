package sk.itlearning.java5.biz;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TimerService;

@Stateless
public class BackendTimer2 {
	
	@Resource private TimerService timerService;
	
    @Schedule(hour = "*", minute = "*", second = "*/30", info = "SCHEDULED_TIMER")
    private void doBackendTask2() {
    	System.out.println("Starting the backend task 2 ...");
    }
    
}
