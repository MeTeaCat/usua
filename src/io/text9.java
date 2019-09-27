package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.management.RuntimeErrorException;
import javax.print.attribute.standard.Fidelity;
/**
找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
比如文件 eclipse.exe，大小是309k。
拆分之后，成为 
eclipse.exe-0
eclipse.exe-1
eclipse.exe-2
eclipse.exe-3

拆分的思路，先把源文件的所有内容读取到内存中，然后从内存中挨个分到子文件里
 */
public class text9 {

	public static void main(String[] args) {
		//每一个划分文件的大小
		int fileSize = 100*1024;
		File f1 = new File("e:/eclipse.exe");
		splitFile(f1,fileSize);
		
		
	}

	private static void splitFile(File f1, int fileSize) {
		//判断文件是否存在
		if(f1.length() == 0) {
			throw new RuntimeException("文件时候0，不可拆分");
		}
		if(!f1.exists()) {
			return;
		}
		
		byte[] b1 = new byte[(int) f1.length()];
		FileInputStream fis = null;
		try {
			//创建输入流
			fis = new FileInputStream(f1);
			fis.read(b1);
			fis.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//计算文件个数
		int count;
		if(f1.length()% fileSize == 0) {
			count = (int) (f1.length() / fileSize);
		}else {
			count = (int) ((f1.length() / fileSize) + 1);
		}
		for (int i = 0; i < count; i++) {
			//创建输出流
			String eachFileName = f1.getName() + "-" + i;
			File f2 = new File(f1.getParent(),eachFileName);
			
			byte[] b2 ;
			if(i != count - 1 ) {
				b2 = Arrays.copyOfRange(b1, fileSize * i, fileSize * (i + 1));
			}else {
				b2 = Arrays.copyOfRange(b1, fileSize * i, b1.length);
			}
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(f2);
				fos.write(b2);
				
				System.out.println("输出子文件" + f2.getAbsolutePath() + "，其大小是 " + f2.length() + "d字节%n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fos != null) {
					try {
						fos.flush();
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}

}
