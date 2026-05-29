class LengthOfTheLastWord{
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // 1. Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Count last word length
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
    public static void main(String[] args) {
        LengthOfTheLastWord lolw = new LengthOfTheLastWord();
        String input = "Hello World   "; // Example input
        int result = lolw.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);
    }
}