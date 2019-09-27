package io;

import java.io.File;

public class text1 {
	public static void main(String[] args) {
		File f1 = new File("E:\\project");
		System.out.println(f1.getAbsolutePath());
		
		File f2 = new File("lol.exe");
		System.out.println(f2.getAbsolutePath());
		
		File f3 = new File(f1,"abc.exe");
		System.out.println(f3.getAbsolutePath());
	
	}
}
