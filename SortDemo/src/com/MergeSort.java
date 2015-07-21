package com;

public class MergeSort {
    // private static long sum = 0;
    /**
     * <pre>
     * 二路归并
     * 原理：将两个有序表合并和一个有序表
     * </pre>
     * 
     * @param a
     * @param firstIndex
     *            第一个有序表的起始下标
     * @param secondIndex
     *            第二个有序表的起始下标
     * @param endIndex
     *            第二个有序表的结束下标
     * 
     */
    private static void mergea(int[] a, int firstIndex, int secondIndex,
            int endIndex) {
        int[] tmp = new int[endIndex - firstIndex + 1];
        int i = firstIndex, j = secondIndex, k = 0;
        while (i < secondIndex && j <= endIndex) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < secondIndex) {
            tmp[k] = a[i];
            i++;
            k++;
        }

        while (j <= endIndex) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, firstIndex, tmp.length);
    }

    /**
     * 
     * @param a
     * @param s
     * @param len
     *            每次归并的有序集合的长度
     */
    public static void mergeSorta(int[] a, int s, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        // -------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
        // ------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            mergea(a, s, s + len, (len << 1) + s - 1);
        }
        // -------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0)
            mergea(a, size - c - 2 * len, size - c, size - 1);
        // -------递归执行下一趟归并排序------//
        mergeSorta(a, 0, 2 * len);
    }

    // ////////////////////////////////////////////////////////////

    // 将有二个有序数列a[first...mid]和a[mid...last]合并。
    public static void mergearray(int a[], int first, int mid, int last,
            int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    public static void mergesort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp); // 左边有序
            mergesort(a, mid + 1, last, temp); // 右边有序
            mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
        }
    }

    public static void mergeSortb(int a[], int n) {
        int[] p = new int[n];
        mergesort(a, 0, n - 1, p);
        mPrintln(a);
    }

    public static void mPrintln(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("||");
    }

    public static void main(String[] args) {
        int[] a = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4, 57,
                22, 58, 65, 78, 145, 4145 };
        int[] b = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4, 57,
                22, 58, 65, 78, 145, 4145 };
        mergeSorta(a, 0, 1);
        mPrintln(a);
        mergeSortb(b, b.length);
    }
}
