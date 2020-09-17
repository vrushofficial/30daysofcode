package day15;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(5);
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        performDFS(result, "", n, n);
        return result;
    }

    public void performDFS(ArrayList<String> result, String s, int left, int right) {

        // not parenthesis left in bucket to be placed
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        // left left parenthesis
        if (left > 0) {
            performDFS(result, s + "(", left - 1, right);
        }
        // left right parenthesis and must have open pair
        if (left < right) {
            performDFS(result, s + ")", left, right - 1);
        }
    }
}
