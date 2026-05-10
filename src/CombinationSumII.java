import java.util.*;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 🔥 important
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp,
                           int[] candidates, int target, int start) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // ❗ skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // ❗ pruning
            if (candidates[i] > target) break;

            temp.add(candidates[i]);

            // move to next index (no reuse)
            backtrack(result, temp, candidates, target - candidates[i], i + 1);

            temp.remove(temp.size() - 1); // backtrack
        }
    }
    public static void main(String[] args) {
        CombinationSumII app = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = app.combinationSum2(candidates, target);
        System.out.println(result); 
    }
}