package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 设计一个方法，用于移除Java文件中的注释 public void removeComments(File javaFile)
 * 比如，移出以//开头的注释行
 * 
 * File f = new File("d:/LOLFolder/LOL.exe"); System.out.println("当前文件是：" +f);
 * //文件是否存在 System.out.println("判断是否存在："+f.exists()); //是否是文件夹
 * System.out.println("判断是否是文件夹："+f.isDirectory()); 注：
 * 如果注释在后面，或者是\/**\/风格的注释，暂不用处理
 */

public class text22 {
	public static void main(String[] args) {
		File f = new File("E:/project/abe.txt");
		removeComments(f);
	}

	private static void removeComments(File f) {
		StringBuffer sb = new StringBuffer();

		try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
			while (true) {
				String readLine = br.readLine();
				if (readLine == null) {
					break;
				}
				//如果不是以//开头，就保存在StringBuffer中
				if(!readLine.trim().startsWith("//")) {
					sb.append(readLine).append("\r\n");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try(FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw)) {
			pw.write(sb.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
