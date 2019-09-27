package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
创建一个Hero对象，设置其名称为garen。 
把该对象序列化到一个文件garen.lol。
然后再通过序列化把该文件转换为一个Hero对象

注：把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
 */
public class textStream {

	public static void main(String[] args) {
		//创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
		Hero h = new Hero();
		h.name = "garen";
		h.hp = 666;
		
		//准备一个文件用于保存该对象
		File f = new File("e:/garen.lol");
		
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
		){
			oos.writeObject(h);
			oos.flush();
			
			Hero h1 = (Hero) ois.readObject();
			System.out.println(h1.name);
			System.out.println(h1.hp);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
