package phonenumber;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    String[] keypad = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        StringBuilder builder = new StringBuilder();
        calculate(digits, 0, builder, combinations);
        return combinations;
    }
    public void calculate(String digits, int index, StringBuilder combo, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(combo.toString());
            return ;
        }
        // numbers begin at character '0' - subtraction nets us correct index for the keypad
        int digit = digits.charAt(index) - '0';
        for(int i = 0; i < keypad[digit].length(); i++) {
            combo.append(keypad[digit].charAt(i));
            calculate(digits, index + 1, combo, combinations);
            combo.deleteCharAt(combo.length() - 1);
        }
    }
}
