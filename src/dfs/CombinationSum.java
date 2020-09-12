import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: alangong
 * @create: 2020-08-26 15:12
 * @description:
 **/
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return result;
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int begin, int target, List<Integer> now) {
        if (target == 0) {
            if (!result.contains(now)) {
                result.add(new ArrayList<>(now));
            }
        } else if (target > 0) {
            for (int i = begin; i < candidates.length; i++) {
                if (target < candidates[i]) break;

                if (i > begin && candidates[i] == candidates[i - 1]) continue;
                now.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], now);
                now.remove(now.size() - 1);
            }
        }
    }

    public List<List<Integer>> traversal(int[] candidates, int times) {
        List<List<Integer>> res = new ArrayList<>();
        dfs2(candidates, times, new ArrayList<>(), res);
        return res;
    }

    // 组合
    private void dfs1(int[] candidates, int times, int begin, List<Integer> now, List<List<Integer>> res) {
        if (times == 0) {
            res.add(new ArrayList<>(now));
        } else {
            for (int i = begin; i < candidates.length; i++) {
                now.add(candidates[i]);
                dfs1(candidates, times - 1, i + 1, now, res);
                now.remove(now.size() - 1);
            }
        }
    }

    // 排列
    private void dfs2(int[] candidates, int times, List<Integer> now, List<List<Integer>> res) {
        if (times == 0) {
            res.add(new ArrayList<>(now));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (!now.contains(candidates[i])) {
                    now.add(candidates[i]);
                    dfs2(candidates, times - 1, now, res);
                    now.remove(now.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 7};
        CombinationSum combinationSum = new CombinationSum();
//        System.out.println(combinationSum.combinationSum(array, 7));
        System.out.println(combinationSum.traversal(array, 2));
    }
}
