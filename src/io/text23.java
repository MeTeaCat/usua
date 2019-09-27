package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class text23 {
	public static void main(String[] args) {
		write();
		read();
	}

	private static void write() {
		File f = new File("e:/abc/1.txt");

		try (FileOutputStream fos = new FileOutputStream(f); DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeBoolean(true);
			dos.writeInt(100);
			dos.writeUTF("I love you");
		} catch (Exception e) {

		}
	}

	private static void read() {
		File f = new File("e:/abc/1.txt");

		try (FileInputStream fis = new FileInputStream(f); DataInputStream dis = new DataInputStream(fis)) {
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			String s = dis.readUTF();
			System.out.println(b);
			System.out.println(i);
			System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
