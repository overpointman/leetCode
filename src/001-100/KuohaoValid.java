import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: alangong
 * @create: 2020-08-13 23:53
 * @description:
 **/
public class KuohaoValid {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Deque<Character> stack = new LinkedList<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(s.charAt(i));
                        break;
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        KuohaoValid test = new KuohaoValid();
        test.isValid("(){}[]");
    }
}
