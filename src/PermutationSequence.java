import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n];
        
        // Step 1: Prepare numbers list
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Step 2: Compute factorials
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        // Step 3: Convert k to 0-based index
        k = k - 1;
        
        StringBuilder result = new StringBuilder();
        
        // Step 4: Build permutation
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            
            k = k % fact[i - 1];
        }
        
        return result.toString();
    }
    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        int n = 3; // Example input
        int k = 3; // Example input
        String result = solution.getPermutation(n, k);
        System.out.println(result); // Output: "213"
    }
  
}