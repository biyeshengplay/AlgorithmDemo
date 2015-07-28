public class BinarySearch {
    /**
     * 二分查找 简介: 在二分搜寻法中，从数列的中间开始搜寻，如果这个数小于我们所搜寻的数，由于数列已排序，则该数左边的数一定都小于要搜寻的对象，
     * 所以无需浪费时间在左边的数；如果搜寻的数大于所搜寻的对象，则右边的数无需再搜寻，直接搜寻左边的数。
     * 
     * @param nums
     *            待查找数组
     * @num 待查找数
     */
    public static int search(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // 与中间值比较确定在左边还是右边区间,以调整区域
            if (num > nums[mid]) {
                low = mid + 1;
            } else if (num < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    // 二分查找的实现
    public static void main(String[] args) {

        int[] nums = { 2, 5, 11, 3, 22, 6, 91, 13, 35, 4 };
        // 对数组进行排序
        QuickSort.quickSort(nums, 0, nums.length - 1);

        int find = BinarySearch.search(nums, 5);

        if (find != -1) {
            System.out.println("找到数值于索引" + find);
        } else {
            System.out.println("找不到数值");
        }
    }

    static class QuickSort {
        public static void quickSort(int[] arr, int left, int right) // 这里只需要数组第一和最后一个下标.
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
                quickSort(arr, left, i - 1); // 以基准值tmp为界,用同样的方式递归调用tmp左边的部分
                quickSort(arr, i + 1, right); // 递归调用右边的部分
            }

        }
    }
}