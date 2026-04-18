import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([)]";
        String test5 = "{[]}";

        System.out.println(test1 + " -> " + solution.isValid(test1)); // true
        System.out.println(test2 + " -> " + solution.isValid(test2)); // true
        System.out.println(test3 + " -> " + solution.isValid(test3)); // false
        System.out.println(test4 + " -> " + solution.isValid(test4)); // false
        System.out.println(test5 + " -> " + solution.isValid(test5)); // true
    }
}