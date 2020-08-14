/**
 * @author: alangong
 * @create: 2020-08-14 14:21
 * @description:
 **/
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (max < area) max = area;
            if (height[i] <= height[j]){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
