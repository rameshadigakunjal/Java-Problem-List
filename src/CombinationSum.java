import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp,
                           int[] candidates, int target, int start) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);

            // stay on same index (reuse allowed)
            backtrack(result, temp, candidates, target - candidates[i], i);

            temp.remove(temp.size() - 1); // backtrack
        }
    }
    public static void main(String[] args) {
        CombinationSum app = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(app.combinationSum(candidates, target));
    }
}