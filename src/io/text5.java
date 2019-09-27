package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class text5 {

	public static void main(String[] args) {
		
		try {
			File f = new File("e://abc/ggg.txt");
			f.getParentFile().mkdirs();
			byte b[] = {96,55};
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(b);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
