class JumpGametwo {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int starIndex = -1, match = 0;

        while (i < s.length()) {
            // Match or '?'
            if (j < p.length() && 
               (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            // '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                match = i;
                j++;
            }
            // Last '*' match fallback
            else if (starIndex != -1) {
                j = starIndex + 1;
                match++;
                i = match;
            }
            // No match
            else {
                return false;
            }
        }

        // Check remaining '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
    public static void main(String[] args) {
        JumpGametwo app = new JumpGametwo();
        String s = "adceb", p = "*a*b";
        boolean result = app.isMatch(s, p);
        System.out.println(result); // Output: true   
         }
}