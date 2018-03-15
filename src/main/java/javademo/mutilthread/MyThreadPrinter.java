package javademo.mutilthread;


/**
 * 使用三个线程交替循环打印ABC
 * 思路：
 * A线程打印后休眠并唤醒B线程->B线程打印后休眠并唤醒C线程->C线程打印后休眠并唤醒A线程->A线程打印后休眠并唤醒B线程->...
 * 
 * @author Mocer
 *
 *	明确概念：
 *	0、notify()和wait()两个方法都是用于synchronize代码块中的方法
 *	1、对象X.notify()   	释放X对象,同时用来唤醒处于wait状态的需要获取X对象锁才能重新运行的线程
 *	2、对象Y.wait()		释放Y对象,同时使当前同步代码块所在的线程休眠
 */
public class MyThreadPrinter implements Runnable{

	// 当前线程的名字
	private String name;
	// 用来休眠当前线程的对象
	private Object cur;
	// 用来通知其他需要此对象锁进行重启线程的对象
	private Object next;

	public MyThreadPrinter(String name, Object cur, Object next)
	{
		this.name = name;
		this.cur = cur;
		this.next = next;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++)
		{
			synchronized (cur) {
				// 当前线程打印,并唤醒下一个需要next对象锁的wait态线程，释放next对象锁
				synchronized (next) {
					System.out.print(name);
					next.notify();
				}
				// 休眠当前线程,释放cur对象锁
				try {
					cur.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		MyThreadPrinter mtpa = new MyThreadPrinter("A", a, b);
		MyThreadPrinter mtpb = new MyThreadPrinter("B", b, c);
		MyThreadPrinter mtpc = new MyThreadPrinter("C", c, a);
		
		new Thread(mtpa).start();
		Thread.sleep(100);
		new Thread(mtpb).start();
		Thread.sleep(100);
		new Thread(mtpc).start();
	}
	
}
