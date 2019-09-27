package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class text4 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("e:\\ac.txt");
		try {
			FileInputStream input = new FileInputStream(f);
			byte[] b = new byte[(int) f.length()];
			input.read(b);
			
			for (byte c : b) {
				System.out.println(c);
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
