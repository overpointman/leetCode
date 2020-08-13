/**
 * @author: alangong
 * @create: 2020-08-13 17:07
 * @description:
 **/
public class AddString {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while(i >= 0 || j >= 0 || add > 0) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int result = a + b + add;
            add = result / 10;
            ans.append(result % 10);
            i--; j--;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        AddString addString = new AddString();
        addString.addStrings("0", "0");
    }
}
