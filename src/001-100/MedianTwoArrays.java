/**
 * @author: alangong
 * @create: 2020-08-05 21:41
 * @description:
 **/
public class MedianTwoArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = (nums1.length + nums2.length) / 2;
        int flag = (nums1.length + nums2.length) % 2;
        if (index == 0) {
            return nums1.length == 0 ? nums2[0] : nums1[0];
        }
        int i = 0, j = 0, count = 0, left = 0, right;
        while (true) {
            int temp;
            if (i >= nums1.length) {
                temp = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                temp = nums1[i];
                i++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    temp = nums1[i];
                    i++;
                } else {
                    temp = nums2[j];
                    j++;
                }
            }
            count++;
            if (count == index) left = temp;
            if (count == index + 1) {
                right = temp;
                break;
            }
        }
        return flag == 0 ? (float)(left + right) / 2.0f : right;
    }
}
