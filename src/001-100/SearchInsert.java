/**
 * @author: alangong
 * @create: 2020-08-16 10:49
 * @description:
 **/
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }
}
