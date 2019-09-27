package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class text8 {

	public static void main(String[] args) {
		
		mergeFile("e:/", "eclipse.exe");

		
		
	}

	private static void mergeFile(String parentFile, String fileName) {
		try {
			//输出文件
			File f1 = new File(parentFile , fileName);
			FileOutputStream fos = new FileOutputStream(f1);
			
			int index = 0;
			while(true) {
				//子文件
				File f2 = new File(parentFile , fileName + index++);
				if(!f2.exists()) {
					break;
				}
				
				byte[] b = new byte[(int) f2.length()];
				FileInputStream fis = new FileInputStream(f2);
				
				fis.read(b);
				fis.close();
				
				fos.write(b);
				fos.flush();
				System.out.println("把子文件" + f2 + "写出到目标文件中");		
			}
			fos.close();
            System.out.println("最后目标文件的大小：" + f1.length() + "字节" );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
