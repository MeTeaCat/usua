package io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class text3 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("E:\\project");
		
		String[] list = f1.list();
		for (String s : list) {
			System.out.println(s);
		}
		
		
		File[] listFiles = f1.listFiles();
		for (File file : listFiles) {
			System.out.println(file.getName());
		}			
		
		String parent = f1.getParent();
		System.out.println(parent);
		
		File parentFile = f1.getParentFile();
		System.out.println(parentFile);
		
		boolean mkdir = f1.mkdir();
		System.out.println(mkdir);
		
		boolean mkdirs = f1.mkdirs();
		System.out.println(mkdirs);
		
		boolean createNewFile = f1.createNewFile();
		System.out.println(f1);
		
		boolean mkdirs3 = f1.getParentFile().mkdirs();
		System.out.println(mkdirs3);
		
		f1.listRoots();
		f1.delete();
		//f1.deleteOnExit();
	}
}
