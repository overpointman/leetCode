/**
 * @author: alangong
 * @create: 2020-08-14 15:08
 * @description:
 **/
public class StrStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        int k = 0;
        int ans = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(k)) {
                boolean equal = true;
                for (; k < needle.length(); k++) {
                    if ((i + k) >= haystack.length()) return -1;
                    if (haystack.charAt(i + k) != needle.charAt(k)) {
                        equal = false;
                        k = 0;
                        break;
                    }
                }
                if (equal) {
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}
