package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
文件加密
在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
加密算法： 
数字：
如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
如果是9的数字，变成0
字母字符：
如果是非z字符，向右移动一个，比如d变成e, G变成H
如果是z，z->a, Z-A。
字符需要保留大小写
非字母字符
比如',&^ 保留不变，中文也保留不变
 *
 */
public class text14 {
	public static void main(String[] args) {
	
		File encodingFile = new File("F:/aa/bb.txt");
		File encodedFile = new File("F:/aa/cc.txt");
		
		encodeFile(encodingFile,encodedFile);
		
		
	}

	private static void encodeFile(File encodingFile, File encodedFile) {
		// 读取encodingFile文件到流
		char[] c = new char[(int) encodingFile.length()];
		try(FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
			fr.read(c);
			System.out.println("加密前输出：");
			System.out.println(new String(c));
			
			//加密
			encode(c);
			System.out.println("加密后输出：");
			System.out.println(new String(c));
			fw.write(c);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

	//加密方法
	private static void encode(char[] c) {
		for (int i = 0; i < c.length; i++) {
			char c1 = c[i];
			if(letterOrDigital(c1)) {
				switch (c1) {
				case '9':
					c1 = '0';
					break;
				case 'z':
					c1 = 'a';
					break;
				case 'Z':
					c1 = 'A';
					break;

				default:
					c1++;
					break;
				}
			}
			c[i] = c1;
		}
		
	}

	private static boolean letterOrDigital(char c1) {
		String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return  -1 == s.indexOf(c1) ? false : true;
	}
}
