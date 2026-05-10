class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: place numbers in correct positions
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n 
                   && nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
    public static void main(String[] args) {
        FirstMissingPositive app = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        int result = app.firstMissingPositive(nums);
        System.out.println(result); // Output: 2
    }
}