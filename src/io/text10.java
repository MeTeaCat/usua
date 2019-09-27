package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拆分文件不同(先把所有数据读取到内存中)，合并文件采用另一种思路。
 * 这种思路，不需要把所有的子文件都先读取到内存中，而是一边读取子文件的内容，一边写出到目标文件
 * 即从eclipse.exe-0开始，读取到一个文件，就开始写出到 eclipse.exe中，然后处理eclipse.exe-1eclipse.exe-2
 * eclipse.exe-3 ... 直到没有文件可以读 合并的思路，就是从eclipse.exe-0开始，读取到一个文件，就开始写出到
 * eclipse.exe中，直到没有文件可以读
 */
public class text10 {

	public static void main(String[] args) {
		mergeFile("e:/", "eclipse.exe");
	}

	private static void mergeFile(String file, String fileName) {
		// 创建输出流,合并成目标文件夹
		File f1 = new File(file, fileName);

		try (FileOutputStream fos = new FileOutputStream(f1)) {

			int index = 0;
			while (true) {
				// 子文件
				File f2 = new File(file, fileName + "-" + index++ );
				if(!f2.exists()) {
					return;
				}
				byte[] b = new byte[(int) f2.length()];
				// 把子文件放进流
				FileInputStream fis = new FileInputStream(f2);
				fis.read(b);
				fis.close();

				fos.write(b);
				System.out.println("把子文件：" + f2.getAbsolutePath() + "放进文件里");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
