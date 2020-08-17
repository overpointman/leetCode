/**
 * @author: alangong
 * @create: 2020-08-17 12:31
 * 直接插入排序
 * 时间 O(n^2) 空间O(1) 稳定
 **/
public class InsertSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
        }
    }
}
