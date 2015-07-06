package com;

public class MainSort {

	public static void main(String[] args) {
		int[] arraya = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 1,
				47, 564, 22, 41 };
		int[] arrayb = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 1,
				47, 564, 22, 41 };
		sorta(arraya);
		sortb(arrayb);
		for (int i = 0; i < arraya.length; i++) {
			System.out.println(arraya[i]);
		}
		System.out.println("==========================");
		for (int i = 0; i < arrayb.length; i++) {
			System.out.println(arrayb[i]);
		}
	}

	// 冒泡排序
	public static void sorta(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// 冒泡排序
	public static void sortb(int[] a) {
		int temp = 0;
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

}
