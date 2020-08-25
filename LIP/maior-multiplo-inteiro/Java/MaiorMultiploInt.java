package Capitulo6;

import java.util.Scanner;

public class MaiorMultiploInt {
	static int INT_MAX = Integer.MAX_VALUE;
	final static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("");
		int num = in.nextInt();
		
		while (num != INT_MAX) {
			num++;
		}
		
		System.out.println("Maior Multiplo: " + num);
	}
}
