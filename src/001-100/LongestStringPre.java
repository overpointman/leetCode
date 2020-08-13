/**
 * @author: alangong
 * @create: 2020-08-13 17:39
 * @description:
 **/
public class LongestStringPre {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String ans = longestCommonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            if ("".equals(ans)) return "";
            ans = longestCommonPrefix(ans, strs[i]);
        }
        return ans;
    }

    private String longestCommonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        for (; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) break;
        }
        return s1.substring(0, i);
    }
}
