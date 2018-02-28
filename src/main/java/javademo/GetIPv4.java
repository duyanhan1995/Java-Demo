package javademo;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GetIPv4 {
	// 创建一个地址集合
	private Set<InetAddress> ipSet = new HashSet<InetAddress>();
	
	@Test
	public void test() {
		// 第一步，获取所有的网络接口
		Enumeration<NetworkInterface> networkInterfaces = null;
		try {
			networkInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		// 第二步，遍历所有的网络接口
		if(networkInterfaces != null)
		{
			while(networkInterfaces.hasMoreElements())
			{
				// 第三步，获取该网络接口上绑定的所有地址
				NetworkInterface networkInterface = networkInterfaces.nextElement();
//				System.out.println(networkInterface.getName());
				Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
				// 第四步，判断所有网络接口上所有地址
				if(inetAddresses != null)
				{
					while(inetAddresses.hasMoreElements())
					{
						InetAddress ip = inetAddresses.nextElement();
						if(ip != null && ip instanceof Inet4Address)
						{
							ipSet.add(ip);
							System.out.println(ip.getHostAddress());
						}
					}
				}
			}
		}
	}

}
