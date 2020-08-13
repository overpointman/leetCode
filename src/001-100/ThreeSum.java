import java.util.*;

/**
 * @author: alangong
 * @create: 2020-08-13 18:20
 * @description:
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        // 遍历时保证i < j < targetIndex
        for (int i = 0; i < nums.length; i++) {
            // i跳过相同的元素
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // 对j进行同样的操作
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int target = -(nums[i] + nums[j]);
                // 第一种情况，三者相同
                if (nums[i] == 0 && nums[j] == 0 && map.get(0) < 3) continue;
                // 第二种情况，nums[j] == target
                if (nums[j] == target && map.get(target) < 2) continue;
                // 避免重复遍历,满足条件说明targetIndex在j右边
                if (target < nums[j] || map.get(target) == null) continue;
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(target);
                result.add(temp);
            }
        }
        return result;
    }
}
