public class FindtheIndexoftheFirstOccurrenceinaString {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i; // match found
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        FindtheIndexoftheFirstOccurrenceinaString app = new FindtheIndexoftheFirstOccurrenceinaString();
        String haystack = "hello";
        String needle = "ll";
        int index = app.strStr(haystack, needle);
        System.out.println("Index of first occurrence: " + index);
    }
}