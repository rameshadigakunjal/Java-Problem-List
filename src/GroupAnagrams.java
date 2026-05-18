import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);                 // sort characters
            String key = new String(arr);     // use sorted string as key
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        GroupAnagrams app = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = app.groupAnagrams(input);
        
        // Print the grouped anagrams
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
