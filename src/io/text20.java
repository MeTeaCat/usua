package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class text20 {
	public static void main(String[] args) {
		File f2 = new File("E:/project/abe.txt");
		
		try (FileWriter fw = new FileWriter(f2); PrintWriter pw = new PrintWriter(fw)) {
			pw.println("garen kill teemo");
			pw.println("teemo revive after 1 minutes");
			pw.println("teemo try to garen, but killed again");
						
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	
	}
}
