package io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
要求
第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。 
注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。

第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字
 */
public class text24 {
	
	static File f = new File("e:/abc/zz.txt");
	static int a = 31;
	static int b = 15;
	
	
	public static void main(String[] args) {
		method1();
		//method2();
	}

	private static void method1() {
		try (
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);				
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
			){
			pw.write(a + "@" + b);
			pw.flush();
			
			String readLine = br.readLine();
			String[] split = readLine.split("@");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			System.out.println("a:" + a + ",b:" + b);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void method2() {
		try (
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);				
		){
			dos.writeInt(a);
			dos.writeInt(b);
			
			int a = dis.readInt();
			int b = dis.readInt();
			System.out.println("a:" + a + ",b:" + b);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
