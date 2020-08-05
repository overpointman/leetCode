import java.util.HashSet;

/**
 * @author: alangong
 * @create: 2020-08-05 21:35
 * @description:
 **/
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        char[] array = s.toCharArray();
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < length) {
            if (set.add(array[right])) {
                right++;
            } else {
                set.remove(array[left]);
                left++;
            }
            int size = right - left;
            if (max < size) max = size;
        }
        return max;
    }
}
