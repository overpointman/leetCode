/**
 * @author: alangong
 * @create: 2020-08-14 01:45
 * @description:
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] == nums[i]) continue;
            nums[i + 1] = nums[j];
            i++;
        }
        return i + 1;
    }
}
