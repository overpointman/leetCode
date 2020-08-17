/**
 * @author: alangong
 * @create: 2020-08-17 17:26
 * 堆排序
 * 时间 O(n*logn) 空间O(logn) 稳定
 * 建堆过程时间复杂度为O(n)具体证明见算法导论
 **/
public class HeapSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        buildMaxHeap(nums);

        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);

            maxHeap(nums, i, 0);
        }
    }

    private static void buildMaxHeap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int half = nums.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(nums, nums.length, i);
        }
    }

    private static void maxHeap(int[] nums, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && nums[left] > nums[index]) {
            largest = left;
        }

        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if (index != largest) {
            swap(nums, index, largest);

            maxHeap(nums, heapSize, largest);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
