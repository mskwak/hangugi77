package com.daou.algorithm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution4 {

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int boonMo = arr.length + 1;
		int plus = 0;
		int minus = 0;
		int zero = 0;

		for(int i = 0, len = arr.length; i < len; i++) {
			if(arr[i] > 0) {
				plus++;
			} else if(arr[i] < 0) {
				minus++;
			} else {
				zero++;
			}
		}

		System.out.format("%.6f\n", (float) plus / boonMo);
		System.out.format("%.6f\n", (float) minus / boonMo);
		System.out.format("%.6f\n", (float) zero / boonMo);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}
}

