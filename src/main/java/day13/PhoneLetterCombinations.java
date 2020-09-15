package day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {
    public static void main(String[] args) {
        PhoneLetterCombinations phoneLetterCombinations = new PhoneLetterCombinations();
        phoneLetterCombinations.findComb("23");
    }

    List<String> findComb(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Map<Character, char[]> phoneDialer = new HashMap<>();
        phoneDialer.put('0', new char[]{});
        phoneDialer.put('1', new char[]{});
        phoneDialer.put('2', new char[]{'a', 'b', 'c'});
        phoneDialer.put('3', new char[]{'d', 'e', 'f'});
        phoneDialer.put('4', new char[]{'g', 'h', 'i'});
        phoneDialer.put('5', new char[]{'j', 'k', 'l'});
        phoneDialer.put('6', new char[]{'m', 'n', 'o'});
        phoneDialer.put('7', new char[]{'p', 'q', 'r', 's'});
        phoneDialer.put('8', new char[]{'t', 'u', 'v'});
        phoneDialer.put('9', new char[]{'w', 'x', 'y', 'z'});
        findCombHelper(digits, builder, phoneDialer, result);
        return result;
    }

    void findCombHelper(String digits, StringBuilder builder, Map<Character, char[]> phoneDialer, List<String> result) {
        /*3. length of digits & build are same- means no next digit present in input*/
        if (digits.length() == builder.length()) {
            result.add(builder.toString());
            return;
        }
        for (char c : phoneDialer.get(digits.charAt(builder.length()))) {
            //add a letter for i.e. builder=a & c is at d
            /* 1. builder=ad  */
            builder.append(c);
            /* 2. recursive check for next digit*/
            findCombHelper(digits, builder, phoneDialer, result);
            /*4. delete last char- d in this case. backtrack to our last input - a in this case*/
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
