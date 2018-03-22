package javademo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用 Timer定时类和TimerTask定时任务类   执行任务
 * 以下这些test中的方法，都放在main方法中执行，才能有直观的显示，使用Junit不好观察
 * @author duyanhan
 *
 *	以下英文原文是重点总结：
 *  So what are the main differences between the Timer and the ExecutorService solution:
 *  
 *  Timer can be sensitive to changes in the system clock; ScheduledThreadPoolExecutor is not
 *  Timer has only one execution thread; ScheduledThreadPoolExecutor can be configured with any number of threads
 *  Runtime Exceptions thrown inside the TimerTask kill the thread, so following scheduled tasks won’t run further; with ScheduledThreadExecutor – the current task will be canceled, but the rest will continue to run
 */
public class UseTimerAndTimerTaskToScheduleATask {

	public static void main(String[] args) throws Exception {
		// 使用Timer定时类和TimerTask定时任务类执行一次任务
//		test();
		// 周期执行任务
//		test2();
		// 一天执行一次任务
//		test3();
		// 取消任务，但不取消定时，相当于：这个任务已经彻底不存在了，但是定时器还在执行，就算换了一个定时器，来执行
		// 这个被取消的任务也是徒劳，因为这个任务已经彻底消失了。
//		test4();
		// 取消定时器，但不取消任务,相当于：当前这个定时器虽然被取消了，
		// 但是任务依然存在，如果有需要，可以继续安排其他的定时器来执行之前被取消的定时器中所执行的任务
//		test5();
		// 使用ExecutorService类去替代Timer定时器类执行周期性任务
		test6();
	}
	
	public static void test() {
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
	
	public static void test2() {
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
	    // 参数period		周期时间（即多长时间执行一次）
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	
	public static void test3() {
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
	
	public static void test4() {
		TimerTask task = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	            cancel();
	        }
	    };
	    Timer timer = new Timer("Timer");
	     
	    timer.scheduleAtFixedRate(task, 1000L, 1000L);
	}
	
	public static void test5() throws Exception {
		TimerTask task = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    Timer timer = new Timer("Timer");
	     
	    timer.scheduleAtFixedRate(task, 1000L, 1000L);
	     
	    Thread.sleep(1000L * 2); 
	    timer.cancel(); 
	}
	
	public static void test6() throws Exception {
		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	            System.out.println("Task performed on " + new Date());
	        }
	    };
	    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	    long delay  = 1000L;
	    long period = 1000L;
	    executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
	    Thread.sleep(delay + period * 3);
	    executor.shutdown();
	}
}

