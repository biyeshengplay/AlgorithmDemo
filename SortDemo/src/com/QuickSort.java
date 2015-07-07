/*
 * 1.我们知道假如一个已排好序的数组,假如是从小到大升序排列,则随便取其中一个数N,则N左边所有数都小于或等于N,右边的都大于或等于N.
 * 
 * 2.那反向思维下,我们先随便取数组第一个数为基准X,然后将所有小于它的数交换到左边,大于它的数交换到右边.最后X可能就被交换到中间某个位置.
 * 以X为分界线,数组被分成两部分.接着再对两部分重复同样的操作.这里用到了递归的思想.
 * 
 * 3.快速排序里面的元素交换又叫填坑,首先取出一个值做标准值basic,则该值所在的位置i变成一个坑,从后面开始遍历碰到大于X的值(假如下标是j)
 * 就把该值交换到位置i,这样位置j就多出一个坑,从前面遍历,碰到大于basic的值(假如位置是i)则把该值交换到位置j.这样i又多出一个坑.
 * 这样不停的从后到前遍历,从前到后遍历,i与j值不断的变.最后i==j时停止.而此时位置i肯定是空着的,于是把值basic移到这里来.这样basic
 * 左边的值都小于它,右边的都大于它了.
 */
package com;

public class QuickSort {

    public static void main(String[] args) {
        int[] arraya = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayb = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        int[] arrayc = new int[] { 5, 56, 45, 46, 14, 755, 15, 87, 71, 594, 4,
                57, 22, 58, 65, 78, 145, 4145 };
        quickSorta(arraya, 0, arraya.length - 1);
        mPrintln(arraya);
        quickSortb(arrayb, 0, arrayb.length - 1);
        mPrintln(arrayb);
        quickSortc(arrayc, 0, arrayc.length - 1);
        mPrintln(arrayc);
    }

    public static void mPrintln(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("==========================");
    }

    public static void quickSorta(int[] arr, int left, int right) // 这里只需要数组第一和最后一个下标.
    {
        if (left < right) {
            int i = left;
            int j = right;
            int tmp = arr[left]; // 就取左边第一个数为基准值.
            while (i < j) // 当i == j时退出循环
            {
                while (i < j && arr[j] >= tmp)
                    // 从后向前遍历,碰到小于tmp的值时停止,该值的索引肯定是j
                    j--;
                if (i < j) {
                    arr[i] = arr[j]; // 把小于tmp的值arr[j]放到位置i
                    i++;
                }
                while (i < j && arr[i] < tmp)
                    // 从前向后遍历,碰到大于tmp的值停止,该值的索引肯定是i
                    i++;
                if (i < j) {
                    arr[j] = arr[i]; // 把大于tmp的值arr[i]放到位置j
                    j--;
                }
            }
            arr[i] = tmp; // 当i = j时退出循环,基准传值被交换到位置i
            quickSorta(arr, left, i - 1); // 以基准值tmp为界,用同样的方式递归调用tmp左边的部分
            quickSorta(arr, i + 1, right); // 递归调用右边的部分
        }

    }

    public static void quickSortb(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (l > low)
            quickSortb(arr, low, l - 1);
        if (h < high)
            quickSortb(arr, l + 1, high);
    }
    
    public static void quickSortc(int[] a, int left, int right) {
        if(left < right) {
            int l = left;
            int h = right;
            int temp = a[right];
            while(l < h) {
                while(l < h && a[l] >= temp) {
                    l++;
                }
                if(l < h) {
                    a[h] = a[l];
                }
                while(l < h && a[h] < temp) {
                    h--;
                }
                if(l < h) {
                    a[l] = a[h];
                }
            }
            a[h] = temp;
            quickSortc(a, left, h-1);
            quickSortc(a, h + 1, right);
        }
    }

}
