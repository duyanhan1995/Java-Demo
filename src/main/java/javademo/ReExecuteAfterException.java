/**
 * 
 */
package javademo;

/**
 * @author Mocer
 * 当程序抛出异常时，重新自动执行
 */
public class ReExecuteAfterException {

	public static int test() {
		int a = 10;
		int b = 0; 
		int c;
		while (true) {
			try {
				c = a/b;
				break;
			} catch (ArithmeticException e) {
				System.out.println("算术异常, 让b自增1");
				b ++;
				continue;
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		test();
	}
}
