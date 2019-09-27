package io;

import java.io.File;
import java.io.FileWriter;

public class text11 {
	public static void main(String[] args) {
		File f = new File("e:/abc1/a.txt");
		f.getParentFile().mkdirs();
		try (FileWriter fw = new FileWriter(f)) {
			String data = "我爱你中国";
			char[] c = data.toCharArray();
			fw.write(c);
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
