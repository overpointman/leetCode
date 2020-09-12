/**
 * @author: alangong
 * @create: 2020-09-12 23:20
 * @description:
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int fi = nums[0], max = fi;
        for (int i = 1; i < nums.length; i++) {
            fi = Math.max(nums[i], fi + nums[i]);
            max = Math.max(max, fi);
        }
        return max;
    }
}
