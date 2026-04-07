public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        
        // Negative numbers are not palindrome
        // Numbers ending with 0 (except 0 itself) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        
        // Reverse half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x = x / 10;
        }
        
        // For even digits: x == reversedHalf
        // For odd digits: x == reversedHalf / 10 (middle digit ignored)
        return (x == reversedHalf || x == reversedHalf / 10);
    }
    public static void main(String[] args) {
        PalindromeNumber solver = new PalindromeNumber();
        int input = 121;

        boolean result = solver.isPalindrome(input);
        System.out.println("Is Palindrome: " + result);
    }
}


