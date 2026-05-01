import java.util.*;

public class LongestValidParentheses {
    public int longestValidParenthese(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i); // reset base
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        LongestValidParentheses app = new LongestValidParentheses();
        String s = "(()())";
        int result = app.longestValidParenthese(s);
        System.out.println("Longest valid parentheses length: " + result);
    }
}