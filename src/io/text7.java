package io;

import java.util.Arrays;

public class text7 {

	public static void main(String[] args) {
		
		int[] b1 = new int[]{96,33,69,58,67,49,22,24};
		
		int[] b2 = Arrays.copyOfRange(b1, 0, 4);
		for (int i = 0; i < b2.length; i++) {
			System.out.println(b2[i]);
		}
		
		int[] b3 = Arrays.copyOfRange(b1, 0, 12);
		for (int i = 0; i < b3.length; i++) {
			System.out.print(b3[i] + " ");
		}
		
		
	}
}
