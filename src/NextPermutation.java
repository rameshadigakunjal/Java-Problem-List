public class NextPermutation {
    public void nextPermutations(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: find decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: find just larger element
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: reverse the remaining part
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    public static void main(String[] args) {
        NextPermutation app = new NextPermutation();
        int[] nums = {1, 2, 3};
        app.nextPermutations(nums);
        System.out.print("Next permutation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}