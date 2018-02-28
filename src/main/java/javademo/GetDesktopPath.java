package javademo;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import org.junit.Test;

public class GetDesktopPath {
	
	@Test
	public void test() {
		// 第一步，获取当前用户的桌面
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		// 第二步，获取该桌面的绝对路径
		String desktopPath = desktopDir.getAbsolutePath();
		System.out.println(desktopPath);
	}
}
