package com;

public class InsertSort {

    public static void main(String[] args) {
        int[] arraya = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayb = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayc = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayd = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        insertSorta(arraya);
        insertSortb(arrayb);
        insertSortc(arrayc);
        insertSortd(arrayd);
    }

    public static void mPrintln(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("==========================");
    }

    //large to small
    public static void insertSorta(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                int temp = a[i];
                int j = i;
                while (j > 0 && a[j - 1] < temp) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = temp;
            }
        }
        mPrintln(a);
    }

    //small to large
    private static void insertSortb(int[] arr) {
        if (arr == null || arr.length < 2) {
            mPrintln(arr);
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    // 接下来是无用功
                    break;
                }
            }
        }
        mPrintln(arr);
    }

    // small to large
    static void insertSortc(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            if (unsorted[i - 1] > unsorted[i]) {
                int temp = unsorted[i];
                int j = i;
                while (j > 0 && unsorted[j - 1] > temp) {
                    unsorted[j] = unsorted[j - 1];
                    j--;
                }
                unsorted[j] = temp;
            }
        }
        mPrintln(unsorted);
    }

    //small to large
    public static void insertSortd(int[] a) {
        int i, pos, tmp;
        for (i = 0; i < a.length - 1; i++) /* from 2 to sorting */
        {
            pos = i + 1;
            tmp = a[pos];
            while (pos >= 1 && tmp < a[pos - 1]) {
                a[pos] = a[pos - 1];
                pos--;
            }
            a[pos] = tmp;
        }
        mPrintln(a);
    }
}
