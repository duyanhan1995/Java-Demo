package javademo;

import org.junit.Test;

// 大致控制程序的运行时间   此处假设运行时间为5分钟
public class ControlProgramRunTime {

	@Test
	public void test() {
		// 先获取程序开始时时间
		long currentTimeMillis = System.currentTimeMillis();
		
		// 获取要运行的大致时间转化成毫秒单位后的数值
		// 这里以5分钟举例
		long time = 5 * 60 * 1000;
		
		// 计算出程序理论上应该结束的时间
		long endTime = time + currentTimeMillis;
		
		
		// 接下来开始执行核心任务
		while(System.currentTimeMillis() < endTime)	// 这个判断会使当前时间超出或等于程序理论终止时间时停止循环
		{
			System.out.println("程序5分钟后停止执行");
		}
	}
}
