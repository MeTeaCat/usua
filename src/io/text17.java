package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
如本例，一个文件中的内容是字符中，编码方式是GBK，那么读出来的数据一定是D6D0。
再使用GBK编码方式识别D6D0，就能正确的得到字符中

注： 在GBK的棋盘上找到的”中”字后，JVM会自动找到”中”在UNICODE这个棋盘上对应的数字，并且以UNICODE上的数字保存在内存中。
 */

public class text17 {
	public static void main(String[] args) {
		File f = new File("F:/aa/ee.txt");
		
		try (FileInputStream fis = new FileInputStream(f);){
			byte[] b = new byte[(int) f.length()];
			fis.read(b);
			System.out.println("文件中读出来的数据是：");
			for (byte c : b) {
				int i = c&0x000000ff;
				System.out.println(Integer.toHexString(i));
			}
			System.out.println("把这个数字，放在GBK的棋盘上去：");
			String string = new String(b,"GBK");
			System.out.println(string);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}
