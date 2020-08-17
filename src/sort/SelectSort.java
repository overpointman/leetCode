/**
 * @author: alangong
 * @create: 2020-08-17 11:40
 * 选择排序
 * 时间 O(n^2) 空间O(1) 不稳定
 **/
public class SelectSort {
    public static void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(nums, i, maxIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
