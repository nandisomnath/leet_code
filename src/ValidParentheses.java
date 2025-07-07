/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

// I will do it later..

import java.util.Stack;

public class ValidParentheses {

    public boolean isPair(char current, char last) {
        // find the index for first match
        switch (last) {
            case '(':
                return current == ')';
            case '{':
                return current == '}';
            case '[':
                return current == ']';
            default:
                return false;
        }
    }

    public boolean isValid(String s) {
        String pairs = "(){}[]";
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check if that is a valid bracket
            if (!pairs.contains(Character.toString(c))) {
                // it not a bracket
                continue;
            }

            // if it is first element in stack
            if (charStack.empty()) {
                charStack.add(c);
                continue;
            }

            // check if a pair
            if (isPair(c, charStack.getLast())) {
                charStack.pop();
            } else {
                charStack.add(c);
            }

        }

        return charStack.empty();
    }

    public static void main(String[] args) {
        String s = "({[)";
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid(s));
    }
}
