package com;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arraya = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594 };
        int[] arrayb = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594 };
        int[] arrayc = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594 };
        int[] arrayd = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594 };
        bubbleSorta(arraya);
        bubbleSortb(arrayb);
        bubbleSortc(arrayc);
        bubbleSortd(arrayd);
    }

    public static void mPrintln(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("==========================");
    }

    public static void bubbleSorta(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        mPrintln(a);
    }

    public static void bubbleSortb(int[] a) {
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
        mPrintln(a);
    }

    public static void bubbleSortc(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        mPrintln(a);
    }

    public static void bubbleSortd(int[] a) {
        int temp = 0;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        mPrintln(a);
    }
}
