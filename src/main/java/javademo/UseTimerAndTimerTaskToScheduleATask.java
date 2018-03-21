package javademo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

/**
 * 使用 Timer定时类和TimerTask定时任务类   执行任务
 * @author duyanhan
 *
 */
public class UseTimerAndTimerTaskToScheduleATask {

	public static void main(String[] args) {
		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    Timer timer = new Timer("Timer");
	     
	    long delay  = 5000L;
	    long period = 3000L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	
	@Test
	public void test() {
		TimerTask task = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on: " + new Date() + "n" +
	              "Thread's name: " + Thread.currentThread().getName());
	        }
	    };
	    Timer timer = new Timer("Timer");
	     
	    long delay = 1000L;
	    // 参数task  要执行的任务
	    // 参数delay 执行该任务前等待的时间
	    timer.schedule(task, delay);
	}
	
	@Test
	public void test2() {
		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    Timer timer = new Timer("Timer");
	     
	    long delay  = 1000L;
	    long period = 1000L;
	    // 参数repeatedTask	要重复执行的任务
	    // 参数delay			周期执行该重复任务前等待的时间(只等待最初一次)
	    // 参数period			周期时间（即多长时间执行一次）
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	
	@Test
	public void test3() {
		// 一下这个重复执行的任务是，一天只执行一次
		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    Timer timer = new Timer("Timer");
	     
	    long delay = 1000L;
	    long period = 1000L * 60L * 60L * 24L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	
}
