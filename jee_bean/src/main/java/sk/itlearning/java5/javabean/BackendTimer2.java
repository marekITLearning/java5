package sk.itlearning.java5.javabean;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateful;
import javax.ejb.TimerService;

@Stateful
public class BackendTimer2 {
	
	@Resource private TimerService timerService;
	
    @Schedule(hour = "*", minute = "*", second = "*/8", info = "Every 8 seconds timer")
    private void doBackendTask2() {
    	System.out.println("Starting the backend task 2 ...");
    }
    
}
