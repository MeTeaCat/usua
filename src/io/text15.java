package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
解密在文件加密中生成的文件。
设计一个方法
 
public static void decodeFile(File decodingFile, File decodedFile);
 

在这个方法中把decodingFile的内容进行解密，然后保存到decodedFile文件中。
解密算法： 
数字：
如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
如果是0的数字，变成9
字母字符：
如果是非a字符，向左移动一个，比如e变成d, H变成G
如果是a，a->z, A-Z。
字符需要保留大小写
非字母字符：
比如',&^ 保留不变，中文也保留不变

 *
 */
public class text15 {
	public static void main(String[] args) {
	
		File encodingFile = new File("F:/aa/cc.txt");
		File encodedFile = new File("F:/aa/dd.txt");
		
		encodeFile(encodingFile,encodedFile);
		
		
	}

	private static void encodeFile(File encodingFile, File encodedFile) {
		// 读取encodingFile文件到流
		char[] c1 = new char[(int) encodingFile.length()];
		try(FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
			fr.read(c1);
			System.out.println("解密前输出：");
			System.out.println(new String(c1));
			
			//加密
			encode(c1);
			System.out.println("解密后输出：");
			System.out.println(new String(c1));
			fw.write(c1);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

	//加密方法
	private static void encode(char[] c1) {
		for (int i = 0; i < c1.length; i++) {
			char c2 = c1[i];
			if(letterOrDigital(c2)) {
				switch (c2) {
				case '0':
					c2 = '9';
					break;
				case 'a':
					c2 = 'z';
					break;
				case 'A':
					c2 = 'Z';
					break;

				default:
					c2--;
					break;
				}
			}
			c1[i] = c2;
		}
		
	}

	private static boolean letterOrDigital(char c2) {
		String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return  -1 == s.indexOf(c2) ? false : true;
	}
}
