import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: alangong
 * @create: 2020-09-12 13:08
 * @description:
 **/
public class Permute {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<Integer> selected = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs2(nums, nums.length, new ArrayList<>(), ans, new ArrayList<>());
        return ans;
    }

    private void dfs2(int[] candidates, int times, List<Integer> now, List<List<Integer>> res, List<Integer> used) {
        if (times == 0) {
            res.add(new ArrayList<>(now));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (!used.contains(i)) {
                    if (i >= 1 && candidates[i] == candidates[i - 1] && !used.contains(i - 1)) continue;
                    now.add(candidates[i]);
                    used.add(i);
                    dfs2(candidates, times - 1, now, res, used);
                    now.remove(now.size() - 1);
                    used.remove(used.size() - 1);
                }
            }
        }
    }
}
