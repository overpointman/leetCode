import java.util.Arrays;

/**
 * @author: alangong
 * @create: 2020-08-20 19:52
 * @description:
 **/
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, 0, nums.length - 1, target);
        int i, j;
        if (index == -1) {
            return new int[]{-1, -1};
        }
        for (i = index; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
        }
        for (j = index; j <= nums.length - 1; j++) {
            if (nums[j] != target) {
                break;
            }
        }
        return new int[]{i + 1, j - 1};
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        SearchRange s = new SearchRange();
        System.out.println(Arrays.toString(s.searchRange(nums, 1)));
    }
}
