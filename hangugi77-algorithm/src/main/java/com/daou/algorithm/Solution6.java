package com.daou.algorithm;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution6 {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		List<Long> list = new ArrayList<>();

		for(int i = 0, len = arr.length; i < len; i++) {
			long sum = 0;

			for(int j = 0; j < len; j++) {
				if(i == j) {
					continue;
				}

				sum += arr[j];
			}

			list.add(sum);
		}

		System.out.println(list.stream().reduce(Long::min).get() + " " + list.stream().reduce(Long::max).get());
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 2};

//		String[] arrItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < 5; i++) {
//			int arrItem = Integer.parseInt(arrItems[i]);
//			arr[i] = arrItem;
//		}


		miniMaxSum(arr);

//		scanner.close();
	}
}

