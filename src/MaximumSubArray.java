public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSubArray msa = new MaximumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,4}; // Example input
        int result = msa.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}

