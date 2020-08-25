package day10;

import java.util.HashMap;
import java.util.Stack;


/*
Time complexity : O(n) because we simply traverse the given string one character at a time
        and push and pop operations on a stack take O(1) time.
*/

public class ValidateParentheses {

    static HashMap<Character, Character> mapping = new HashMap<Character, Character>();

    public static boolean isValid(String s) {

        mapping.put((Character) '}', (Character) '{');
        mapping.put((Character) ']', (Character) '[');
        mapping.put((Character) ')', (Character) '(');

        if (s.trim().length() == 0)
            return true;
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            Character c = s.charAt(i);

            //if char is closing bracket and top TOS contains same opening bracket
            if (!stack.isEmpty() && mapping.getOrDefault(c, '\0').equals(stack.peek()))
                stack.pop();
                // If it's an opening bracket, push to the stack.
            else
                stack.push(c);
        }
        if (stack.isEmpty())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[[]{}]]{()([{[()]}])}([])"));
    }

}

/*
class Stack {
    int max=1000;
    int top = -1;
    Character[] s = new Character[max];

    boolean push(Character node) {
        if (top >= max)
            return false;
        else {
            s[++top] = node;
            return true;
        }
    }

    boolean isEmpty()
    {
        if(top==0) return true;
        else return false;
    }
    Character pop() {
        Character popped = '\0';
        if (top < 0)
            return '\0';
        else
            popped = s[top--];
        return popped;
    }
}
*/

