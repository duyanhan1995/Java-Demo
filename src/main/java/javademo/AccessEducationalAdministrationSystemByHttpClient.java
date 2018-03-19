package javademo;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 利用HttpClient工具通过Cookies访问教务系统
 * @author Mocer
 *
 */
public class AccessEducationalAdministrationSystemByHttpClient {
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://218.65.107.173/content.aspx");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36"));
		nvps.add(new BasicNameValuePair("Referer", "http://218.65.107.173/xs_main.aspx?xh=14223209"));
		nvps.add(new BasicNameValuePair("Cookie", "这里填上成功登陆后使用fiddler工具在登录过程中抓取到的Cookie"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
			// 访问状态
		    System.out.println(response2.getStatusLine());
		    HttpEntity entity2 = response2.getEntity();
		    // do something useful with the response body
		    if(entity2 != null) {
		    	String string = EntityUtils.toString(entity2);
		    	System.out.println(string);
		    }
		    // and ensure it is fully consumed
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
	}
}
