package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.management.RuntimeErrorException;
/**
找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
比如文件 eclipse.exe，大小是309k。
拆分之后，成为 
eclipse.exe-0
eclipse.exe-1
eclipse.exe-2
eclipse.exe-3
 */
public class text6 {

	public static void main(String[] args) {
		
		int eachSize = 100*1024;
		File f = new File("e:/eclipse.exe");
		splitFile(f, eachSize);
		
	}

	private static void splitFile(File f, int eachSize) {
		
		//判断文件是否是空的
		if(!f.exists()) {
			throw new RuntimeException("文件长度为0，不可拆分");
		}
		//把文件读取到数组里面
		byte[] b1 = new byte[(int) f.length()];
		
		try {
			FileInputStream fis = new FileInputStream(f);
			fis.read(b1);
			fis.close();			
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 计算需要被划分成多少份子文件
		int count;
		if(f.length()%eachSize == 0) {
			count = (int) (f.length() / eachSize);
		}else {
			count = (int) ((f.length() / eachSize) + 1);
					
		}
		
		for (int i = 0; i < count; i++) {
			//文件名和输出的对象
			String eachFileName = f.getName() + i;
			File f2 = new File(f.getParent(),eachFileName);
			
			//把文件输出到数组里面
			byte[] b2 ;
			// 从源文件的内容里，复制部分数据到子文件,除开最后一个文件，其他文件大小都是100k,最后一个文件的大小是剩余的

			if( i != count - 1) {
				b2 = Arrays.copyOfRange(b1, eachSize * i, eachSize*(i+1));
			}else {
				b2 = Arrays.copyOfRange(b1, eachSize * i, b1.length);
			}
			
			try {
				FileOutputStream fos = new FileOutputStream(f2);
				fos.write(b2);
				fos.close();
				System.out.println("输出子文件:" + eachFileName + "，其大小是字节:" + f2.length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
	}
}
