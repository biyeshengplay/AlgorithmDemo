package com;

public class SelectSort {

    public static void main(String[] args) {
        int[] arraya = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayb = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        // int[] arrayc = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594,
        // 4,
        // 57, 22, 58, 65, 78, 145, 4145 };
        // int[] arrayd = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594,
        // 4,
        // 57, 22, 58, 65, 78, 145, 4145 };
        selectSorta(arraya);
        selectSortb(arrayb);
    }

    public static void mPrintln(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("==========================");
    }

    public static void selectSorta(int[] a) {
        int minIndex = 0;
        int temp = 0;
        if ((a == null) || (a.length == 0))
            return;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;// 无序区的最小数据数组下标
            for (int j = i + 1; j < a.length; j++) {
                // 在无序区中找到最小数据并保存其数组下标
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // 如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
                temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        mPrintln(a);
    }

    public static void selectSortb(int[] a) {
        int maxIndex = 0;
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            maxIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                temp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = temp;
            }
        }
        mPrintln(a);
    }
}
