/**
 * @author: alangong
 * @create: 2020-08-16 12:04
 * @description:
 **/
public class Search {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (left >= right) {
            return -1;
        }

        if (nums[left] < nums[mid]) {
            // 左半有序
            if (target == nums[left]) return left;
            if (target > nums[left] && target < nums[mid]) {
                return binarySearch(nums, target, left + 1, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, right);
            }
        } else {
            //右半有序
            if (target == nums[right]) return right;
            if (target > nums[mid] && target < nums[right]) {
                return binarySearch(nums, target, mid + 1, right - 1);
            } else {
                return binarySearch(nums, target, left, mid - 1);
            }
        }
    }
}
