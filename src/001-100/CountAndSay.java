/**
 * @author: alangong
 * @create: 2020-08-26 12:27
 * @description:
 **/
public class CountAndSay {
    public String countAndSay(int n) {
        String ans = "1";
        StringBuilder temp = new StringBuilder();
        while (n != 1) {
            char cur = ans.charAt(0);
            int count = 1;
            for (int i = 1; i < ans.length(); i++) {
                if (cur == ans.charAt(i)) {
                    count++;
                } else {
                    temp.append(count).append(cur);
                    cur = ans.charAt(i);
                    count = 1;
                }
            }
            temp.append(count).append(cur);
            ans = temp.toString();
            temp.delete(0, temp.length());
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay(5));
    }
}
