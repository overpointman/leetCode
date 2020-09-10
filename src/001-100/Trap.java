/**
 * @author: alangong
 * @create: 2020-08-26 23:43
 * @description:
 **/
public class Trap {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax > height[left]) {
                    sum += (leftMax - height[left]);
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    sum += (rightMax - height[right]);
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap.trap(nums);
    }
}
