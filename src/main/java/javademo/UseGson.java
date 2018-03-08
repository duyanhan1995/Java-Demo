package javademo;

import org.junit.Test;

import com.google.gson.Gson;

import javademo.UseGsonLib.Data;
import javademo.UseGsonLib.Other;

public class UseGson {
	
	@Test
	public void test() {
		// 第一步，初始化复杂数据类型
		Data data = new Data();
		data.setData1("data1");
		data.setData2("data2");
			Other other = new Other();
			other.setOther1("other1");
			other.setOther2("other2");
		data.setOther(other);
		
		// 第二步，创建Gson对象
		Gson gson = new Gson();
		String json = gson.toJson(data);
		System.out.println(json);
		
	}
}
