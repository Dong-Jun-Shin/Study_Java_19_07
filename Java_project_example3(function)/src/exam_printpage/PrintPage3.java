﻿package exam_printpage;

import java.util.Scanner;

public class PrintPage3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[10];

		/*
		 * int[] n = new int[2]; for (int i = 0; i < n.length; i++) {
		 * System.out.println((i + 1) + "번째 수를 입력해주세요."); n[i] = scan.nextInt(); if
		 * (n[i] < 10) { System.out.println("숫자를 다시 입력해주세요."); i--; } }
		 */

		while (true) {
			System.out.println("숫자 두 개를 입력해 주세요:");
			array[0] = scan.nextInt();
			array[1] = scan.nextInt();

			if (array[0] < 10 && array[1] < 10) {
				break;
			}
			System.out.println("숫자를 다시 입력해주세요.");
		}

		for (int i = 2; i < array.length; i++) {
			array[i] = (array[i - 2] * array[i - 1]) % 10;
		}

		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i<array.length-1) {
			System.out.print(", ");
			}
		}
		System.out.println("]");
		scan.close();
	}
}
