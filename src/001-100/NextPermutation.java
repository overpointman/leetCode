import java.util.Arrays;

/**
 * @author: alangong
 * @create: 2020-08-16 11:28
 * @description:
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            // 从右往左找第一个右大于左的元素
            if (nums[i] > nums[i - 1]) {
                // 从右往左找第一个大于目标元素的元素
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        reverse(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        if (i == 0) reverse(nums, 0, nums.length);
    }

    /**
     * 翻转数组，左闭右开
     * @param nums
     * @param fromIndex
     * @param toIndex
     */
    public void reverse(int[] nums, int fromIndex, int toIndex) {
        for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
