import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: dengKai
 * @date: 2023/04/03 11:57
 * @description: TODO
 */

public class TestCase {

    public static void main(String[] args) {
        String testText = "I love python, learn python make me happy, PHP is the first language";
        char[] chars = testText.toCharArray();
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = countMap.get(chars[i]);
            if (integer != null) {
                countMap.put(chars[i], countMap.get(chars[i]) + 1);
            } else {
                countMap.put(chars[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
