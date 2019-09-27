package io;

public class text21 {
	public static void main(String[] args) {

		String s1 = "this is my startsWith string";
		String sd = "startsWith";
		if (s1.startsWith(sd)){
			// startsWith()方法判断字符串s1是否从字符串sd开始
			s1 = s1.substring(sd.length());
		}else if (s1.endsWith(sd)) {
			// endWith()方法判断字符串s1是否从字符串sd结尾
			s1 = s1.substring(0, s1.length() - sd.length());
		}else {
			int index = s1.indexOf(sd);
			// indexOf()搜索字符或子字符串首次出现，这里的index等于11
			if (index != -1) {
				String s2 = s1.substring(0, index);
				// 从字符串s1的首字符开始，取index个字符
				String s3 = s1.substring(index + sd.length());
				// 取字符串s1的第19个字符后面的字符串
				s1 = s2 + s3;
			} else
				System.out.println("string \"" + sd + "\" not found");
		}
		System.out.println(s1);
	}

}
