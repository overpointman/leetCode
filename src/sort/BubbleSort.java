/**
 * @author: alangong
 * @create: 2020-08-17 11:27
 * 冒泡排序
 * 时间 O(n^2) 空间O(1) 稳定
 **/
public class BubbleSort {
    public static void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
