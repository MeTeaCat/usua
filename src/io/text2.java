package io;

import java.io.File;
import java.util.Date;

public class text2 {
	public static void main(String[] args) {
		File f1 = new File("E:\\project\\lol.exe");
		System.out.println(f1.getAbsolutePath());
		
		System.out.println("文件是否存在：" + f1.exists());
		System.out.println("是否是文件夹：" + f1.isDirectory());
		System.out.println("是否是文件：" + f1.isFile());
		System.out.println("文件长度" + f1.length());
		
		
		long lastModified = f1.lastModified();
		System.out.println(lastModified);
		Date date1 = new Date(lastModified);
		System.out.println("最后修改时间：" + date1);
		
		f1.setLastModified(0);
		Date date2 = new Date(lastModified);
		System.out.println(date2);
		
		File f2 = new File("E:\\project\\abc.exe");
		f1.renameTo(f2);
		
	}
}
