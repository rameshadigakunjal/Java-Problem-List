public class StringtoInteger {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // 1. Skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
    public static void main(String[] args) {
        StringtoInteger solver = new StringtoInteger();
        String input = "   -42";

        int result = solver.myAtoi(input);
        System.out.println("Converted Integer: " + result);
    }
}
