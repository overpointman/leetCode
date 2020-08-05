import java.util.Arrays;

/**
 * @author: alangong
 * @create: 2020-08-05 21:22
 * @description:
 **/
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[2];
        while(i < j) {
            if (target == (nums[i] + nums[j])) {
                result[0] = i;
                result[1] = j;
            } else if (target > (nums[i] + nums[j])) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}

