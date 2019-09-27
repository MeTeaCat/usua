package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
然后把该数组序列化到一个文件heros.lol
接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样

 */
import java.io.Serializable;

public class textStream2 implements Serializable {
	public static void main(String[] args) {

		Hero[] h = new Hero[10];
		for (int i = 0; i < h.length; i++) {
			h[i] = new Hero("hero:" + i);
		}
		System.out.println(h[2]);
		File f = new File("e:/heros.lol");
		
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			 //把数组序列化到文件heros.lol
			oos.writeObject(h);
			Hero[] h1 = (Hero[]) ois.readObject();
			System.out.println("查看中文件中反序列化出来的数组中的每一个元素：");
			for (Hero hero : h) {
				System.out.println(hero.name);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
	}
}
