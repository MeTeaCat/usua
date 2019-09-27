package io;

import java.io.File;
import java.io.FileReader;

public class text12 {
	public static void main(String[] args) {
	
		File f = new File("e:/abc1/a.txt");
	
		try (FileReader fr = new FileReader(f)){
			char[] c = new char[(int) f.length()];
			fr.read(c);
			
			for (char d : c) {
				System.out.println(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
