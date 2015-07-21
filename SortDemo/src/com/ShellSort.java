package com;

public class ShellSort {

    public static void main(String[] args) {
        int[] arraya = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayb = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayc = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        shellsorta(arraya, arraya.length);
        shellsortb(arrayb, arrayb.length);
        shellsortc(arrayc, arrayc.length);
    }

    public static void mPrintln(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("||");
    }

    public static void shellsorta(int a[], int n) {
        int i, j, gap;

        for (gap = n / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) // 直接插入排序
            {
                for (j = i + gap; j < n; j += gap)
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
            }
        }
        mPrintln(a);
    }

    public static void shellsortb(int a[], int n) {
        int j, gap;

        for (gap = n / 2; gap > 0; gap /= 2)
            for (j = gap; j < n; j++)
                // 从数组第gap个元素开始
                if (a[j] < a[j - gap])// 每个元素与自己组内的数据进行直接插入排序
                {
                    int temp = a[j];
                    int k = j - gap;
                    while (k >= 0 && a[k] > temp) {
                        a[k + gap] = a[k];
                        k -= gap;
                    }
                    a[k + gap] = temp;
                }
        mPrintln(a);
    }

    public static void shellsortc(int a[], int n) {
        int i = 0;
        int j = 0;
        int gap = 0;
        int temp = 0;

        for (gap = n / 2; gap > 0; gap /= 2)
            for (i = gap; i < n; i++)
                for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                    // Swap(a[j], a[j + gap]);
                }
        mPrintln(a);
    }
}
