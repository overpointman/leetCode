import java.util.Arrays;

/**
 * @author: alangong
 * @create: 2020-08-17 11:37
 * @description:
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,23,5,2,54,32,5656,54,223,9,5};
//        BubbleSort.sort(nums);
//        SelectSort.sort(nums);
//        InsertSort.sort(nums);
//        QuickSort.sort(nums);
//        MergeSort.sort(nums);
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
