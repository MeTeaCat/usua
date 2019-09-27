package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class text19 {
	public static void main(String[] args) {
		File f1 = new File("E:/project/abe.txt");
		
		
		try (FileReader fr =  new FileReader(f1); BufferedReader br = new BufferedReader(fr);){
			while(true) {
				String readLine = br.readLine();
				if(readLine == null) {
					break;
				}
				System.out.println(readLine);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}
}

