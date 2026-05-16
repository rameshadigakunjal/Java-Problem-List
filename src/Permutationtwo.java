import java.util.*;

class Permutationtwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // important
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // skip used elements
            if (used[i]) continue;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(result, temp, nums, used);

            // backtrack
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        Permutationtwo app = new Permutationtwo();  
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = app.permuteUnique(nums);
        System.out.println(result); // Output: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}