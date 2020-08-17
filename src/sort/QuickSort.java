/**
 * @author: alangong
 * @create: 2020-08-17 12:40
 * 快速排序
 * 时间 O(n*logn) 空间O(logn) 不稳定 最坏O(n^2)
 **/
public class QuickSort {
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right, target = nums[left];
        while(i < j) {
            while(i < j && nums[j] > target) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] <= target) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = target;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
