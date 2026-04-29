import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seenMap = new HashMap<>();

            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (wordMap.containsKey(word)) {
                    seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (seenMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    seenMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords app = new SubstringwithConcatenationofAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> indices = app.findSubstring(s, words);
        System.out.println("Starting indices: " + indices);
    }
}