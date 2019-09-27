package io;

import java.io.File;
import java.io.InputStream;

public class text25 {
	public static void main(String[] args) {
		// 控制台输入
		try (InputStream is = System.in;) {

			int b = is.read();
			System.out.println(b);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
