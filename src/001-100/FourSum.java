import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-13 22:02
 * @description:
 **/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = nums.length - 1;
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    while (k < l && (target - nums[i] - nums[j] - nums[k]) < nums[l]) {
                        l--;
                    }
                    // 指针重合后续不用遍历
                    if (k == l) break;
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[l]);
                        ans.add(result);
                    }
                }
            }
        }
        return ans;
    }
}
