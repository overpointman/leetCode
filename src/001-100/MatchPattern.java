import java.util.HashMap;
import java.util.Map;

/**
 * @author: alangong
 * @create: 2020-08-06 23:31
 * @description:
 **/
public class MatchPattern {
    private int[][] array = new int[][]{
            {1, -1, -1, 1, 1, 1, 1},
            {5, 5, 5, 5, 5, 5, 5},
            {10, 10, 10, -10, -10, 10, 10},
            {50, 50, 50, 50, 50, 50, 50},
            {100, 100, 100, 100, 100, -100, -100},
            {500, 500, 500, 500, 500, 500, 500},
            {1000, 1000, 1000, 1000, 1000, 1000, 1000}
    };

    private Map<Character, Integer> valueMap = new HashMap<>();

    public int romanToInt(String s) {
        init(valueMap);
        char[] charArray = s.toCharArray();
        int sum = 0;
        for (int i = 0; i <  s.length(); i++) {
            if (i != s.length() - 1) {
                sum += getValue(charArray[i], charArray[i + 1]);
            } else {
                sum += getValue(charArray[i], charArray[i]);
            }

        }
        return sum;
    }

    private void init(Map<Character, Integer> map) {
        valueMap.put('I', 0);
        valueMap.put('V', 1);
        valueMap.put('X', 2);
        valueMap.put('L', 3);
        valueMap.put('C', 4);
        valueMap.put('D', 5);
        valueMap.put('M', 6);
    }

    private int getValue(char left, char right) {
        return array[valueMap.get(left)][valueMap.get(right)];
    }
}
