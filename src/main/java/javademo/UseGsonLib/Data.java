package javademo.UseGsonLib;

public class Data {

	String data1;
	String data2;
	Other other;
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public Other getOther() {
		return other;
	}
	public void setOther(Other other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Data [data1=" + data1 + ", data2=" + data2 + ", other=" + other + "]";
	}
	
	
}
